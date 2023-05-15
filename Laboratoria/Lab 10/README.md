# Laboratorium 10

## Aplikacje sieciowe

### Zadanie 1

Napisz serwer czatu sieciowego. Serwer powinien pozwolić dołączyć dowolnej liczbie użytkowników. Serwer powinien oczekiwać na wiadomość od dowolnego użytkownika i rozsyłać tę wiadomość wszystkim użytkownikom.

### Zadanie 2

Napisz klienta czatu sieciowego współpracującego z napisanym serwerem. Klient powinien odczytywać standardowe wejście i przesyłać je do serwera oraz odbierać wiadomości z serwera i wyświetlać je na standardowym wyjściu.

### Zadanie 3a

Niech działanie klienta rozpoczyna się zawsze od wpisania loginu. Login powinien zostać przesłany serwerowi w postaci sformatowanej wiadomości. Zakładamy, że użytkownicy podadzą unikalne loginy. W chwili zalogowania pozostali użytkownicy czata powinni otrzymać informację o dołączeniu użytkownika, a chwili wyłączenia klienta o opuszczeniu przez niego czatu.

### Zadanie 3b

Jeżeli użytkownik wpisze /online, powinien otrzymać listę aktualnie zalogowanych użytkowników.

### Zadanie 4a

Niech wszystkie wiadomości użytkowników w czacie rozpoczynają się od ich loginów.

### Zadanie 4b

Jeżeli użytkownik napisze w czacie /w recipient message, gdzie recipient jest loginem odbiorcy, a message wysłaną wiadomością, należy przesłać tą wiadomość wyłącznie wybranemu odbiorcy. Jeżeli nie jest on zalogowany, należy wyświetlić nadawcy stosowną informację.

### Zadanie 5

Jeżeli użytkownik napisze w czacie /file recipient path, gdzie recipient jest loginem odbiorcy, a path ścieżką do pliku, należy przesłać ten plik odbiorcy. Podczas przesyłania należy prezentować aktualny, procentowy, postęp kopiowania. Jeżeli odbiorca nie jest zalogowany, należy wyświetlić nadawcy stosowną informację.
