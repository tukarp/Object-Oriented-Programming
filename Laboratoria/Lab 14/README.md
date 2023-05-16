# Laboratorium 14

## Powtórzenie 2

### Zadanie 1

Zaznajom się z dołączonym plikiem app-view.fxml. Zaprogramuj funkcjonalność rysowania kół wewnątrz stworzonej kanwy. Koła powinny być tworzone po kliknięciu myszą w obszarze kanwy. Środek koła powinien być w miejscu kliknięcia. Kolor wypełnienia i promień należy ustawić na podstawie odczytów ze stosownych kontrolek na interfejsie.

### Zadanie 2

W głównym pakiecie aplikacji stwórz dwa podpakiety: server i client, w których umieszczone zostaną klasy odpowiadające zadanym funkcjonalnościom. W pakiecie server zdefiniuj klasę Server, w której istnieć będzie ServerSocket, do którego będą mogli się łączyć klienci, reprezentowani w serwerze klasą ClientThread. W klasie Server stwórz publiczną metodę broadcast(), która prześle otrzymaną wiadomość wszystkim klientom. ClientThread powienien po każdym otrzymaniu wiadomości przesyłać ją dalej za pomocą metody broadcast serwera.

W pakiecie client zdefiniuj klasę ServerThread, przyjmuje metodę send(), przyjmującą parametry potrzebne do stworzenia okręgu i wysyła je serwerowi.

### Zadanie 3

Zdefiniuj rekord Dot składający się ze współrzędnych środka koła, koloru i promienia. Zaimplementuj w nim statyczną metodę toMessage, przyjmującą wszystkie wymienione parametry i zwracającą sformatowany String, który może być wysłany sieciowo. Napisz statyczną metodę fromMessage, która przyjmie taki String i odczyta z niego i zwróci obiekt klasy Dot.

### Zadanie 4

Dodaj obiekty klas Server i ServerThread do kontrolera okna za pomocą parametrów konstruktora. Zastąp wyświetlenie okręgu wywołaniem metody send() obiektu klasy ServerThread. Wewnątrz ServerThread stwórz pole konsumenta zmiennej typu Dot i mutator do tego pola. Konsument powinien być wywoływany dla danych każdego okręgu, które dotrą do klienta. Niech konstruktor kontrolera ustawia konsumenta w taki sposób, by realizował te same zadania, co dotychczasowa metoda rysująca okręgi.

### Zadanie 5

Zdefiniuj połączenie z bazą danych i utwórz w niej następującą tabelę:

```
CREATE TABLE dot (
    id     INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    x      INTEGER NOT NULL,
    y      INTEGER NOT NULL,
    color  TEXT NOT NULL,
    radius INTEGER NOT NULL
);
```

Niech serwer, w momencie wystartowania łączy się z tą bazą. Wewnątrz serwera zdefiniuj metodę saveDot(), przyjmującą obiekt Dot, która zapisuje jego zawartość w bazie.

Napisz metodę getSavedDots(), która zwraca wszystkie zapisane koła w postaci listy Dot. Niech metoda broadcast() zapisuje koło do bazy. Chwilę po dołączeniu nowego klienta, należy mu przesłać wszystkie wygenerowane okręgi. Utwórz pomocniczą, niestatyczną metodę klasy Dot, generującą wiadomość na postawie parametrów koła zawartych w obiekcie.
