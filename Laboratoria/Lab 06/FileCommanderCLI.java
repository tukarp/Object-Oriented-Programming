package com.company;

import java.util.function.Function;
import java.util.Optional;
import java.util.Arrays;
import java.io.*;

public class FileCommanderCLI {
    private BufferedReader reader;
    private BufferedWriter writer;
    private FileCommander fileCommander;
    private BufferedOutputStream outputStream;

    public FileCommanderCLI(InputStream in, OutputStream out) {
        this.reader = new BufferedReader(new InputStreamReader(in));
        this.writer = new BufferedWriter(new OutputStreamWriter(out));
        this.outputStream = new BufferedOutputStream(outputStream);
        this.fileCommander = new FileCommander();
    }

    public void eventLoop() {
        while(true){
            try {
                String line = reader.readLine();
                runCommand(line);
                writer.flush();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void runCommand(String command)throws IOException {
        String[] commandArr =command.split(" ");

        switch (commandArr[0]) {
            case "pwd" -> writer.write(fileCommander.pwd() + "\n");
            case "cd" -> fileCommander.cd(commandArr[1]);
            case "ls" -> writer.write(runLs(Arrays.copyOfRange(commandArr,1, commandArr.length)) + "\n");
            case "find" -> writer.write(fileCommander.find(commandArr[1]).toString()+ "\n");
            default -> writer.write("Unknown command\n");
        }
    }

    private final String filterPrefix = "--filter=";
    public String runLs(String[] parameters) {
        Optional<String> filterParameter = Arrays.stream(parameters)
                .filter(entry -> entry.startsWith(filterPrefix))
                .findFirst();

        String substring = filterParameter.map(s -> s.substring(filterPrefix.length())).orElse(null);

        Function<String, String> dirFormatFunction;
        if(Arrays.asList(parameters).contains("--color")) {
            dirFormatFunction = FileCommander::formatDirColor;
        } else {
            dirFormatFunction = FileCommander::formatDirBraces;
        }

        return fileCommander.ls(dirFormatFunction, substring).toString();
    }
}
