# Laboratorium 13

## Bazy danych

Utwórz bazę ```SQLite``` składającą się z pojedynczej tabeli:

```
CREATE TABLE person (
id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
first_name TEXT NOT NULL,
last_name TEXT NOT NULL
);
```

Zapełnij tę tabelę przykładowymi danymi.

### Zadanie 1

Napisz klasę ```DatabaseConnection``` posiadającą prywatne, statyczne pole typu ```java.sql.Connection.``` Napisz publiczny, statyczny akcesor do tego pola oraz publiczne, statyczne metody ```connect()``` i ```disconnect()``` nawiązujące i zrywające połączenie z bazą danych.


### Zadanie 2

Napisz klasę ```Person``` posiadającą pola analogiczne do kolumn tabeli. Napisz konstruktor ustawiający te pola oraz funkcje ```toString()```. Napisz publiczną, statyczną metodę, która odczyta z bazy i zwróci w postaci listy obiektów ```Person``` całą zawartość tabeli.

### Zadanie 3

W klasie ```Person``` napisz publiczną, statyczną metodę, która przyjmie napis. Metoda powinna zwrócić listę obiektów ```Person``` zawierających dane z tablicy, których pole ```last_name``` jest równe przekazanemu parametrowi.

Napisz kolejną, podobną metodę, która zwróci osoby, których nazwisko rozpoczyna się od danego argumentem podciągu.

### Zadanie 4

W klasie ```Person``` napisz publiczną, statyczną metodę, która przyjmie napisy: ```firstName``` i ```lastName``` i utworzy w tabeli nowy wiersz z tymi polami.

Napisz podobną metodę, która zadziała w taki sam sposób, ale dodatkowo zwróci ```id```, który został utworzony dla nowego wiersza.

Do samodzielnego zaprogramowania metody modyfikujące i usuwające wiersze.

### Zadanie 5

Korzystając ze strony ```https://start.spring.io/``` utwórz projekt, w którym jako zależności wskazane zostaną ```Spring Web``` i ```Thymleaf```. Następnie zaimportuj go w ```IDE```. Utwórz klasę będącą kontrolerem wyświetlanych treści oraz odpowiadającą mu stronę ```HTML```. Przetestuj wyświetlanie wartości zmiennych.

### Zadanie 6

Do utworzonego projektu dodaj klasy ```DatabaseConnection``` i ```Person```. Zmodyfikuj stronę tak, aby wyświetlała wszystkie obiekty ```Person``` zwrócone przez funkcję napisaną w zadaniu 2.

### Zadanie 7

Do strony dodaj formularz składający się z dwóch pól: imię i nazwisko oraz przycisku. Po naciśnięciu przycisku dane z formularza należy dodać jako kolejny wiersz do tabeli w bazie i wyświetlić na stronie.
