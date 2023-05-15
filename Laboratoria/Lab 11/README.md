# Laboratorium 11

## Graficzny interfejs użytkownika

### Zadanie 1

Zaprojektuj okno czatu w którym będzie znajdowały obiekty klas:

- TextArea - wieloliniowe pole tekstowe z zapisem czatu,
- TextField - pole tekstowe do wprowadzania nowej wiadomości,
- ListView - lista aktywnych uczestników czatu,
- 2x Button - do wysyłania wiadomości oraz do wysyłania pliku.

Zaprogramuj przycisk do wysyłania wiadomości tak, aby jego naciśnięcie powodowało dopisanie wiadomości z obiektu klasy TextField do TextArea i wyczyszczenie zawartości obiektu klasy TextField. Analogicznie powinno działać naciśnięcie entera w polu wiadomości.

### Zadanie 2

Z napisanego wcześniej tekstowego klienta czatu usuń klasę Main. Skompiluj pozostałą część do biblioteki w pliku JAR. Użyj tej biblioteki w okienkowym kliencie czatu. Przetestuj jej działanie uruchamiając metodę logowania.

### Zadanie 3a

W stworzonej bibliotece stwórz interfejs o nazwie ClientReceiver. Zdefiniuj w nim funkcje odpowiadające wszystkim dotychczas obsługiwanym działaniom (broadcast, whisper, login broadcast, logout broadcast, online, file). W ServerThread póki co obsłuż broadcast. Wiadomość rozróżnij na podstawie prefiksu.

### Zadanie 3b

W okienkowym kliencie stwórz klasę ClientGUIReceiver implementującą ClientReceiver, która będzie obsługiwać komunikację zwrotną z serwera. Korzystając z takiej konstrukcji klas, napisz funkcjonalność przesyłania broadcastowych wiadomości.

### Zadanie 4

Obsłuż wyświetlanie listy użytkowników. Podczas logowania klient powinien poprosić serwer o wysłanie mu aktualnej listy. Login broadcast i logout broadcast powinny dodawać i usuwać użytkownika z listy.

### Zadanie 5

Do głównego okna dodaj obiekt klasy ProgressBar. Zaprogramuj przycisk wysyłania pliku, jak aby otwierał dialog wyboru plików. Zaprogramuj przesyłanie pliku aktywnemu użytkownikowi z listy. Postęp przesyłania należy wyświetlić w kliencie otrzymującym plik.
