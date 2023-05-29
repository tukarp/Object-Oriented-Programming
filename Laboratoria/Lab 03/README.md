# Programowanie Obiektowe

## Laboratorium 03 - Wzorce projektowe

### Zadanie 1

Napisz klasę ```SolidFilledPolygon``` dziedziczącą po ```Polygon```. Klasa powinna posiadać prywatne pole ```String``` ```color``` ustawiane, obok tablicy punktów, w konstruktorze. Przemodeluj funkcję ```toSvg``` w interfejsie ```Shape``` tak, aby możliwe było przekazanie jej parametru typu ```String```, który zostanie umieszczony w tagu rysowanego obiektu. Wykorzystaj poniższy kod:

```
<polygon points=\"%s\" %s />
```

W klasie ```SolidFilledPolygon``` zdefiniuj metodę ```toSvg```, która nadpisze metodę klasy nadrzędnej. Wewnątrz tej metody wywołaj metodę ```toSvg``` klasy nadrzędnej, przekazując jej jako parametr napis powstały ze sformatowania:

```
fill=\"%s\" %s
```

kolejno kolorem i parametrem napisowym.

Zastanów się, jakie konsekwencje dla struktury programu miałoby stworzenie analogicznej klasy dziedziczącej po klasie ```Ellipse``` oraz próba dodawania innych parametrów do tagu.

### Zadanie 2

W pakiecie głównym aplikacji utwórz subpakiet ```decorators``` Będą w niej umieszczane wszystkie klasy zawierające w nazwie ```Decorator```. Zdefiniuj klasę ```ShapeDecorator``` implementującą interfejs ```Shape```, która posiadać będzie chronione pole ```Shape``` ```decoratedShape```. Pole to powinno być ustawiane w konstruktorze. Nadpisz metodę ```toSvg``` w taki sposób, by zawierała wywołanie tej samej metody na rzecz obiektu ```decoratedShape```.

Po klasie ```ShapeDecorator``` podziedzicz nową klasę ```SolidFillShapeDecorator```. Klasa ta powinna posiadać prywatne pole ```String``` ```color```. W konstruktorze ma przyjmować obiekt klasy ```Shape``` oraz kolor wypełnienia typu ```String```. W jej metodzie ```toSvg``` wywołaj metodę ```toSvg``` na rzecz ```decoratedShape```, z parametrami jak w zadaniu 1.

Utwórz dwa obiekty klasy ```SolidFillShapeDecorator``` tak, aby parametrem jednego był obiekt wielokąta, a drugiego elipsy.

### Zadanie 3

Utwórz klasę ```StrokeShapeDecorator``` posiadającą prywatne pola ```String``` ```color``` i ```double``` ```width```, które powinny być ustawione w konstruktorze. Wywołaj metodę ```toSvg``` podobnie jak w zadaniu 2. formatując napis:

```
stroke=\"%s\" stroke-width=\"%f\"
```

kolorem i grubością obrysu. Przetestuj udekorowanie tą klasą obiektów będących wynikiem poprzedniego zadania.

### Zadanie 4

Utwórz klasę ```TransformationDecorator``` odpowiadającą za wpisanie w wyświetlany tab informacji o przekształceniach afinicznych: translacji, rotacji i skalowaniu. Na potrzeby każdego z tych działań stwórz prywatne pola:

- ```boolean``` ```translate```, ```Vec2``` ```translateVector```,
- ```boolean``` ```rotate```, ```double``` ```rotateAngle```, ```Vec2``` ```rotateCenter```,
- ```boolean``` ```scale```, ```Vec2``` ```scaleVector```.

Wewnątrz klasy ```TransformationDecorato```r zdefiniuj publiczną klasę ```Builder```. Zdefiniuj w niej prywatne pola, jednakowe z polami w klasie zewnętrznej oraz pole ```Shape``` ```shape```. Wartości logiczne powinny być fałszywe. Napisz po jednej metodzie ustawiającej parametry transformacji i zmieniającej wartość logiczną na prawdziwą na znak, że transformacja ma się wykonać. Funkcje powinny zwracać obiekt klasy ```Builder``` z wprowadzonymi zmianami. Napisz w klasie ```Builder``` metodę ```build```, która utworzy obiekt ```TransformationDecorator```, przekazując mu jako parametr obiekt ```shape```, a następnie ustawi wszystkim polom w tym obiekcie wartości zapisane w obiekcie ```Buildera``` i zwróci tak stworzony obiekt.

W klasie ```TransformationDecorator``` nadpisz metodę ```toSvg``` tak, aby poskładać w niej napis definiujący transformację z elementów:

```translate(%f %f) ```, translateVector.x, translateVector.y
```rotate(%f %f %f) ```, rotateAngle, rotateCenter.x, rotateCenter.y
```scale(%f %f) ```, scaleVector.x, scaleVector.y

Umieść je w we własności ```transform```:

```
"transform=\"%s\" %s", result, parameters.
```

Przetestuj tworzenie klasy TransformationDecorator za pomocą całości lub części dostępnych transformacji.

### Zadanie 5a

W klasie ```SvgScene``` utwórz prywatne, statyczne pole ```SvgScene``` ```instance```, początkowo równe ```null```. Napisz akcesor do tego pola. Jeżeli znajduje się tam ```null```, należy je zainicjalizować.

### Zadanie 5b

Dodaj do klasy SvgScene tablicę ```String``` ```defs[]``` oraz metodę dodającą elementy do tej tablicy, wzorując się na tablicy ```shapes``` i metodzie ```addShape```. W metodzie ```saveHtml``` uwzględnij dopisanie tagów ```<defs>``` do wynikowego pliku. Zdefiniuj klasę ```DropShadowDecorator``` dziedziczącą po ```ShapeDecorator```. Jej zadaniem jest udekorowanie obiektu ```Shape``` rzucanym cieniem. Jest to realizowane przez umieszczenie w tagu ```<defs>``` sformatowanego kodu:

```
\t<filter id=\"f%d\" x=\"-100%%\" y=\"-100%%\" width=\"300%%\" height=\"300%%\">\n" +
"\t\t<feOffset result=\"offOut\" in=\"SourceAlpha\" dx=\"5\" dy=\"5\" />\n" +
"\t\t<feGaussianBlur result=\"blurOut\" in=\"offOut\" stdDeviation=\"5\" />\n" +
"\t\t<feBlend in=\"SourceGraphic\" in2=\"blurOut\" mode=\"normal\" />\n" +
"\t</filter>", index
```

oraz w metodzie ```toSvg```:

```
"filter=\"url(#f%d)\" ", index
```

gdzie w obu przypadkach ```index``` jest liczbą całkowitą, unikalną dla tego filtra. Unikalność indeksu zagwarantuj przy użyciu prywatnego, statycznego pola klasy.

### Zadanie 6
Łącząc wiedzę wyniesioną z zadania 4 i 5 zdefiniuj klasę ```GradientFillShapeDecorator``` dziedziczącą po ```ShapeDecorator```, której celem jest wypełnienie kształtu poziomym, barwnym gradientem. Gradient wymaga umieszczenia w tagu ```<defs>``` napisu rozpoczynającego się od:

```
"\t<linearGradient id=\"g%d\" >\n", index
```

a następnie dla każdego koloru i jego położenia:

```
\t\t<stop offset=\"%f\" style=\"stop-color:%s\" />\n", stop.offset, stop.color,
```

gdzie ```stop.offset``` jest liczbą zmiennoprzecinkową z przedziału 0-1, a stop.color napisem. Definicję gradientu zamyka:

```
"\t</linearGradient>"
```

Wewnątrz klasy zdefiniuj klasę ```Builder```. W klasie ```Builder``` stwórz metodę, która przyjmuje offset i kolor, a której wielokrotne wywołania pozwalają stworzyć tablicę tych wartości definiującą przebieg gradientu.
W metodzie ```toSvg``` klasy zewnętrznej wykorzystaj sformatowany napis:

```
"fill=\"url(#g%d)\" ", index
```
