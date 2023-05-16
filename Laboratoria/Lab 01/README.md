# Programowanie Obiektowe

## Laboratorium 01 - Klasa i obiekt

### Zadanie 1

Zdefiniuj klasę Point posiadającą dwa publiczne, ostateczne pola x, y. Napisz konstruktor ustawiający te wartości.

Zdefiniuj klasę Line reprezentującą odcinek, posiadającą dwa prywatne punkty klasy Point. Wygeneruj akcesory i mutatory klasy Line. Napisz publiczną metodę, która zwraca długość odcinka. W kolejnym kroku usuń mutatory i utwórz konstruktor ustawiający te pola na wartości swoich dwóch parametrów.

### Zadanie 2

Zdefiniuj w klasie Line publiczną metodę toSvg(), która zwróci napis zawierający kod języka znacznikowego SVG pozwalający wyświetlić tę linię.

### Zadanie 3

Napisz funkcję (metodę klasy głównej), która przyjmie: obiekt l klasy Line oraz obiekt p klasy Point. Funkcja powinna zwrócić odcinek prostopadły do l, rozpoczynający się w punkcie p o długości równej odcinkowi l. Następnie zmodyfikuj tę metodę tak, aby zwracała tablicę dwóch możliwych do konstrukcji linii oraz przenieś tę metodę jako statyczną do klasy Line. Szczególne przypadki należy zignorować.

### Zadanie 4

Zdefiniuj klasę Polygon posiadającą prywatną tablicę punktów. Konstruktor tej klasy powinien przyjmować liczbę wierzchołków. Napisz dwa mutatory wierzchołków: (1) przyjmujący indeks w tablicy i punkt, który ma zostać zastąpiony oraz (2) tablicę punktów. Napisz publiczną metodę toSvg() działającą analogicznie jak w poprzednim zadaniu.