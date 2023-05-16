import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Server {
    private ServerSocket serverSocket;
    private List<ClientThread> clients = new ArrayList<>();

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen(){
        while(true){
            Socket clientSocket;
            try {
                clientSocket = serverSocket.accept();
                ClientThread thread = new ClientThread(clientSocket, this);
                clients.add(thread);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeClient(ClientThread client) {
        clients.remove(client);
        broadcastLogout(client);
    }

    public void broadcast(ClientThread sender, String message){
        for(var currentClient : clients)
            if(currentClient != sender)
                currentClient.send(sender.getClientName() + ": " + message);

    }

    public void broadcastLogin(ClientThread client) {
        for(var currentClient : clients)
            if(currentClient != client)
                currentClient.send(client.getClientName() + " joined the chat");
    }

    public void broadcastLogout(ClientThread client) {
        for(var currentClient : clients)
            currentClient.send(client.getClientName() + " left the chat");
    }

    private Optional<ClientThread> getClient(String clientName) {
        return clients.stream()
                .filter(client -> clientName.equals(client.getClientName()))
                .findFirst();
    }

    public void whisper(ClientThread sender, String message) {
        String[] messageArr = message.split(" ");
        String recipientName = messageArr[0];

        Optional<ClientThread> recipient = getClient(recipientName);
        if(recipient.isPresent()) {
            recipient.get().send(sender.getClientName() + " whispers: " + messageArr[1]);
        } else sender.send("No such user: " + recipientName);
    }

    public void online(ClientThread sender) {
        List<String> list = clients.stream()
                .map(ClientThread::getClientName)
                .collect(Collectors.toList());
        sender.send(list.toString());
    }

    public void sendFile(ClientThread sender, String message) throws IOException {
        String[] messageArr = message.split(" ");
        String recipientName = messageArr[0];
        long fileSize = Long.parseLong(messageArr[1]);
        String fileName = messageArr[2];

        Optional<ClientThread> recipient = getClient(recipientName);

        if(recipient.isPresent()) {
            DataInputStream fileIn = new DataInputStream(sender.getSocket().getInputStream());
            DataOutputStream fileOut = new DataOutputStream(recipient.get().getSocket().getOutputStream());

            byte[] buffer = new byte[64];
            long receivedSize = 0;
            int count;

            recipient.get().send("FI" + sender.getClientName() + " " + fileSize + " " + fileName);
            while(receivedSize < fileSize) {
                count = fileIn.read(buffer);
                receivedSize += count;
                System.out.println(receivedSize + " " + (fileSize - receivedSize));
                fileOut.write(buffer, 0, count);
            }
        } else sender.send("No such user: " + recipientName);
    }
}
