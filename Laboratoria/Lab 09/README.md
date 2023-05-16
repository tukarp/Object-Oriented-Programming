# Programowanie Obiektowe

## Laboratorium 09 - Testy

### Zadanie 1a

Wydziel metodę obliczającą indeks tablicy na podstawie miesiąca i daty do statycznej, publicznej metody w klasie Product.

### Zadanie 1b

Napisz test sprawdzający poprawność działania przeliczania indeksu.

### Zadanie 1c

Napisz test sprawdzający poprawność rzucania wyjątku IndexOutOfBoundsException.

### Zadanie 1d

Napisz parametryzowany test sprawdzający poprawność działania przeliczania indeksu.

### Zadanie 1e

Przygotuj plik CSV zawierający wszystkie potencjalne, miesiące, lata i odpowiadające im indeksy z przedziału 01.2010 - 03.2022. Napisz test wykorzystujący ten plik.

### Zadanie 1f

Napisz test sprawdzający wszystkie potencjalne miesiące od 2001 roku. Uczyń asumpcję, która spowoduje, że test dla lat wcześniejszych niż 2010 nie będzie sprawdzany.

### Zadanie 2a

Napisz test sprawdzający poprawność załadowania danych z pliku przez metodę FoodProduct::fromCsv na podstawie nazwy odczytanej z obiektu za pomocą akcesora.

### Zadanie 2b

Napisz test sprawdzający poprawność załadowania danych z pliku przez metodę FoodProduct::fromCsv na poprzez trójargumentową metodę Product::getPrice.

### Zadanie 2c

Napisz test sprawdzający poprawność załadowania danych z pliku przez metodę FoodProduct::fromCsv na poprzez dostęp do mapy cen będącej prywatną zmienną.

### Zadanie 2d

Napisz test sprawdzający poprawność załadowania danych z pliku przez metodę FoodProduct::fromCsv na poprzez dostęp do mapy eksponowanej przez akcesor zdefiniowany w klasie dziedziczącej po FoodProduct. Wprowadź konieczne, minimalne zmiany w kodzie FoodProduct.

### Zadanie 3a

W celu przetestowania metody Product::getProduct załóżmy, że metoda Product::addProducts jest już przetestowana. Napisz metodę uruchamianą przed testami, która:

- utworzy tymczasowy katalog,
- utworzy w niej kilka plików o strukturze odpowiadającej plikom oczekiwanym przez FoodProduct::fromCsv,
- doda je za pomocą metody Product::addProducts do statycznej listy 
- Napisz metodę, która wywoła się po wszystkich testach, która usunie tymczasowy katalog wraz zawartością. 
- Napisz test sprawdzający odczytywanie prefiksu w metodzie Product::getProduct poprzez porównanie go z nazwą znalezionego obiektu.

### Zadanie 3b

Napisz fabrykę dynamicznych testów, które przetestują poprawność działania metody Product::getProduct dla wszystkich wygenerowanych plików.
