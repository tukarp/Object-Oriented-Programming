# Laboratorium 04

## Pliki, napisy, serializacja

### Zadanie 1

Zdefiniuj klasę Person posiadającą prywatne pola name klasy String oraz birth, death klasy LocalDate. Utwórz w niej metodę fabrykującą fromFile, tworzącą obiekt na podstawie pliku o ścieżce danej argumentem. Plik powinien zawierać w kolejnych liniach: imię i nazwisko; datę urodzenia; (opcjonalnie) datę śmierci. Daty podawane są w formacie dd.MM.yyyy. Nadpisz metodę toString. Zagwarantuj, aby metoda fromFile była jedynym sposobem utworzenia obiektu klasy Person.

### Zadanie 2

Dany jest plik CSV, w którego kolejnych wierszach zapisane są linie według schematu:

Imię i nazwisko; data urodzenia; (opcjonalnie) data śmierci.

Napisz publiczną, statyczną metodę klasy Person fromCsv, przyjmującą ścieżkę do pliku o podanym schemacie, która tworzy i zwraca tablicę obiektów Person na podstawie jego zawartości.

### Zadanie 3

Napisz publiczne, statyczne metody klasy Person:

- toFile - przyjmującą obiekt Person i ścieżkę do pliku, zapisującą dane według schematu z zadania 1,
- toCsv - przyjmującą tablicę obiektów Person i ścieżkę do pliku, zapisującą dane według schematu z zadania 2.

Napisz publiczną, statyczną metodę sortCsv klasy Person, która przyjmie ścieżkę do pliku CSV i posortuje dane w pliku rosnąco według daty urodzenia. Wykorzystaj napisane wcześniej metody.

### Zadanie 4

Napisz publiczne, statyczne metody klasy Person:

- toDirectory - przyjmującą tablicę obiektów Person i ścieżkę do katalogu. Jeżeli katalog nie istnieje, należy go utworzyć, a w przeciwnym razie wyczyścić. W katalogu, dla każdej osoby należy stworzyć plik o nazwie odpowiadającej polu name i rozszerzeniu txt zawierający dane według schematu z zadania 1.
- fromDirectory - przyjmującą ścieżkę do katalogu, zwracającą tablicę obiektów Person.

### Zadanie 5

Napisz publiczne, statyczne metody klasy Person:

- toBinaryFile - przyjmującą tablicę obiektów Person i ścieżkę do pliku. Metoda powinna umieścić w pliku dane z tablicy w postaci binarnej.
- fromBinaryFile - przyjmującą ścieżkę do pliku binarnego, zwracającą tablicę obiektów Person. Metoda powinna odczytać plik stworzony przez metodę toBinaryFile.

### Zadanie 6

Zdefiniuj klasę User, dziedziczącą po Person, z polami login i password. Napisz publiczne statyczne metody klasy User:

- toEncryptedFile - przyjmującą tablicę obiektów User i ścieżkę do pliku. Metoda powinna umieścić w pliku dane z tablicy w postaci binarnej, ale zaszyfrowane dowolną metodą, w których kluczem będzie "password",
- fromEncryptedFile - przyjmującą ścieżkę do pliku binarnego, zwracającą tablicę obiektów User. Metoda powinna odczytać plik stworzony przez metodę toEncryptedFile.
