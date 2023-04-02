# Programowanie Obiektowe

## Spis Treści

### Laboratoria

- [Lab 1 - Klasa i obiekt](#lab-1---klasa-i-obiekt)
- [Lab 2 - paradygmaty programowania obiektowego](#lab-2---paradygmaty-programowania-obiektowego)
- [Lab 3 - Wzorce projektowe](#lab-3---wzorce-projektowe)
- [Lab 4 - Pliki, napisy, serializacja](#lab-4---pliki-napisy-serializacja)
- [Lab 5 - Wyjątki](#lab-5---wyjątki)
- [Lab 6 - Strumienie](#lab-6---strumienie)
- [Lab 7 - Programowanie generyczne](#lab-7---programowanie-generyczne)
- [Lab 8 - Powtórzenie 1](#lab-8---powtórzenie-1)
- [Lab 9 - Testy](#lab-9---testy)
- [Lab 10 - Aplikacje sieciowe](#lab-10---aplikacje-sieciowe)
- [Lab 11 - Graficzny interfejs użytkownika](#lab-11---graficzny-interfejs-użytkownika)
- [Lab 12 - Gra](#lab-12---gra)
- [Lab 13 - Bazy danych](#lab-13---bazy-danych)
- [Lab 14 - Powtórzenie 2](#lab-14---powtórzenie-2)

## Laboratorium 1 - Klasa i obiekt

### Zadanie 1

Zdefiniuj klasę Point posiadającą dwa publiczne, ostateczne pola x, y. Napisz konstruktor ustawiający te wartości.

Zdefiniuj klasę Line reprezentującą odcinek, posiadającą dwa prywatne punkty klasy Point. Wygeneruj akcesory i mutatory klasy Line. Napisz publiczną metodę, która zwraca długość odcinka. W kolejnym kroku usuń mutatory i utwórz konstruktor ustawiający te pola na wartości swoich dwóch parametrów.

### Zadanie 2

Zdefiniuj w klasie Line publiczną metodę toSvg(), która zwróci napis zawierający kod języka znacznikowego SVG pozwalający wyświetlić tę linię.

### Zadanie 3

Napisz funkcję (metodę klasy głównej), która przyjmie: obiekt l klasy Line oraz obiekt p klasy Point. Funkcja powinna zwrócić odcinek prostopadły do l, rozpoczynający się w punkcie p o długości równej odcinkowi l. Następnie zmodyfikuj tę metodę tak, aby zwracała tablicę dwóch możliwych do konstrukcji linii oraz przenieś tę metodę jako statyczną do klasy Line. Szczególne przypadki należy zignorować.

### Zadanie 4

Zdefiniuj klasę Polygon posiadającą prywatną tablicę punktów. Konstruktor tej klasy powinien przyjmować liczbę wierzchołków. Napisz dwa mutatory wierzchołków: (1) przyjmujący indeks w tablicy i punkt, który ma zostać zastąpiony oraz (2) tablicę punktów. Napisz publiczną metodę toSvg() działającą analogicznie jak w poprzednim zadaniu.

### [Rozwiązanie](https://github.com/tukarp/Object-Oriented-Programming/tree/main/Laboratoria/Lab%2001)

## Laboratorium 2 - Paradygmaty programowania obiektowego

### Zadanie 1

Zdefiniuj klasę Style o finalnych, publicznych polach klasy String: fillColor, strokeColor oraz Double: strokeWidth. Napisz konstruktor trójargumentowy ustawiający te wartości. Należy dopuścić ustawienie polom wartości null. Napisz publiczną metodę toSvg() zwracającą napis, który można umieścić w opcji style tagu <polygon>.

Zmodyfikuj klasę Polygon dodając do jej konstruktora argument Style i modyfikując jej metodę toSvg(), aby uwzględniała styl. Jeżeli mają wartość null, należy narysować przezroczysty (fillColor) wielokąt, z czarnym obrysem (strokeColor) o grubości jednego piksela (strokeWidth).

### Zadanie 2

Napisz klasę SvgScene posiadającą prywatną tablicę obiektów Polygon. Napisz metodę, która przyjmuje obiekt klasy Polygon oraz dodaje go do tablicy w obiekcie SvgScene. Napisz funkcję saveHtml(String), która utworzy plik HTML w ścieżce danej argumentem i zapisze do niego reprezentacje wszystkich wielokątów znajdujących się na kanwie. 

### Zadanie 3

Napisz publiczną, statyczną metodę fabrykującą klasę Polygon o nazwie square. Funkcja powinna przyjąć jako argumenty: obiekt Line, obiekt Style i zwrócić wielokąt będący kwadratem, którego przekątną jest dany odcinek.

Przeciąż metodę klasy Line zwracającą prostopadły odcinek tak, aby przyjmowała jako dodatkowy argument długość zwracanego odcinka.

### Zadanie 4

Utwórz klasę abstrakcyjną Shape, która otrzyma jako pole obiekt klasy Style. Uczyń pole tego obiektu chronionym. Utwórz publiczny konstruktor, który ustawia to pole. Napisz czysto wirtualną metodę toSvg(). Zmodyfikuj klasę Polygon, aby dziedziczyła po klasie Shape.

### Zadanie 5

Napisz klasę Ellipse dziedziczącą po Shape, posiadającą prywatne pola: środek elipsy (Point), długości promieni i styl. W jej implementacji metody toSvg() powinno znaleźć się rysowanie z użyciem tagu <ellipse>.

Zmodyfikuj klasę SvgScene, aby posiadała tablicę obiektów klasy Shape i korzystając z polimorfizmu zapisz w niej obiekty typu Polygon i Ellipse.

### [Rozwiązanie](https://github.com/tukarp/Object-Oriented-Programming/tree/main/Laboratoria/Lab%2002)

## Laboratorium 3 - Wzorce projektowe

### Zadanie 1

Napisz klasę SolidFilledPolygon dziedziczącą po Polygon. Klasa powinna posiadać prywatne pole String color ustawiane, obok tablicy punktów, w konstruktorze. Przemodeluj funkcję toSvg w interfejsie Shape tak, aby możliwe było przekazanie jej parametru typu String, który zostanie umieszczony w tagu rysowanego obiektu. Wykorzystaj poniższy kod:
"<polygon points=\"%s\" %s />"
W klasie SolidFilledPolygon zdefiniuj metodę toSvg, która nadpisze metodę klasy nadrzędnej. Wewnątrz tej metody wywołaj metodę toSvg klasy nadrzędnej, przekazując jej jako parametr napis powstały ze sformatowania:
"fill=\"%s\" %s "
kolejno kolorem i parametrem napisowym.

Zastanów się, jakie konsekwencje dla struktury programu miałoby stworzenie analogicznej klasy dziedziczącej po klasie Ellipse oraz próba dodawania innych parametrów do tagu.

### Zadanie 2

W pakiecie głównym aplikacji utwórz subpakiet “decorators” Będą w niej umieszczane wszystkie klasy zawierające w nazwie “Decorator”. Zdefiniuj klasę ShapeDecorator implementującą interfejs Shape, która posiadać będzie chronione pole Shape decoratedShape. Pole to powinno być ustawiane w konstruktorze. Nadpisz metodę toSvg w taki sposób, by zawierała wywołanie tej samej metody na rzecz obiektu decoratedShape.

Po klasie ShapeDecorator podziedzicz nową klasę SolidFillShapeDecorator. Klasa ta powinna posiadać prywatne pole String color. W konstruktorze ma przyjmować obiekt klasy Shape oraz kolor wypełnienia typu String. W jej metodzie toSvg wywołaj metodę toSvg na rzecz decoratedShape, z parametrami jak w zadaniu 1.

Utwórz dwa obiekty klasy SolidFillShapeDecorator tak, aby parametrem jednego był obiekt wielokąta, a drugiego elipsy.

### Zadanie 3

Utwórz klasę StrokeShapeDecorator posiadającą prywatne pola String color i double width, które powinny być ustawione w konstruktorze. Wywołaj metodę toSvg podobnie jak w zadaniu 2. formatując napis
"stroke=\"%s\" stroke-width=\"%f\" "
kolorem i grubością obrysu. Przetestuj udekorowanie tą klasą obiektów będących wynikiem poprzedniego zadania.

### Zadanie 4

Utwórz klasę TransformationDecorator odpowiadającą za wpisanie w wyświetlany tab informacji o przekształceniach afinicznych: translacji, rotacji i skalowaniu. Na potrzeby każdego z tych działań stwórz prywatne pola:

- boolean translate, Vec2 translateVector,
- boolean rotate, double rotateAngle, Vec2 rotateCenter,
- boolean scale, Vec2 scaleVector.

Wewnątrz klasy TransformationDecorator zdefiniuj publiczną klasę Builder. Zdefiniuj w niej prywatne pola, jednakowe z polami w klasie zewnętrznej oraz pole Shape shape. Wartości logiczne powinny być fałszywe. Napisz po jednej metodzie ustawiającej parametry transformacji i zmieniającej wartość logiczną na prawdziwą na znak, że transformacja ma się wykonać. Funkcje powinny zwracać obiekt klasy Builder z wprowadzonymi zmianami. Napisz w klasie Builder metodę build, która utworzy obiekt TransformationDecorator, przekazując mu jako parametr obiekt shape, a następnie ustawi wszystkim polom w tym obiekcie wartości zapisane w obiekcie Buildera i zwróci tak stworzony obiekt.

W klasie TransformationDecorator nadpisz metodę toSvg tak, aby poskładać w niej napis definiujący transformację z elementów:
"translate(%f %f) ", translateVector.x, translateVector.y
"rotate(%f %f %f) ", rotateAngle, rotateCenter.x, rotateCenter.y
"scale(%f %f) ", scaleVector.x, scaleVector.y

Umieść je w we własności “transform”:
"transform=\"%s\" %s", result, parameters.

Przetestuj tworzenie klasy TransformationDecorator za pomocą całości lub części dostępnych transformacji.

### Zadanie 5a

W klasie SvgScene utwórz prywatne, statyczne pole SvgScene instance, początkowo równe null. Napisz akcesor do tego pola. Jeżeli znajduje się tam null, należy je zainicjalizować. 

### Zadanie 5b

Dodaj do klasy SvgScene tablicę String defs[] oraz metodę dodającą elementy do tej tablicy, wzorując się na tablicy shapes i metodzie addShape. W metodzie saveHtml uwzględnij dopisanie tagów <defs> do wynikowego pliku.

Zdefiniuj klasę DropShadowDecorator dziedziczącą po ShapeDecorator. Jej zadaniem jest udekorowanie obiektu Shape rzucanym cieniem. Jest to realizowane przez umieszczenie w tagu <defs> sformatowanego kodu:

```
\t<filter id=\"f%d\" x=\"-100%%\" y=\"-100%%\" width=\"300%%\" height=\"300%%\">\n" +
"\t\t<feOffset result=\"offOut\" in=\"SourceAlpha\" dx=\"5\" dy=\"5\" />\n" +
"\t\t<feGaussianBlur result=\"blurOut\" in=\"offOut\" stdDeviation=\"5\" />\n" +
"\t\t<feBlend in=\"SourceGraphic\" in2=\"blurOut\" mode=\"normal\" />\n" +
"\t</filter>", index
```

oraz w metodzie toSvg:

```
"filter=\"url(#f%d)\" ", index
```

gdzie w obu przypadkach index jest liczbą całkowitą, unikalną dla tego filtra. Unikalność indeksu zagwarantuj przy użyciu prywatnego, statycznego pola klasy.

### Zadanie 6

Łącząc wiedzę wyniesioną z zadania 4 i 5 zdefiniuj klasę GradientFillShapeDecorator dziedziczącą po ShapeDecorator, której celem jest wypełnienie kształtu poziomym, barwnym gradientem.

Gradient wymaga umieszczenia w tagu <defs> napisu rozpoczynającego się od:
"\t<linearGradient id=\"g%d\" >\n", index
a następnie dla każdego koloru i jego położenia:
\t\t<stop offset=\"%f\" style=\"stop-color:%s\" />\n", stop.offset, stop.color,
gdzie stop.offset jest liczbą zmiennoprzecinkową z przedziału 0-1, a stop.color napisem. Definicję gradientu zamyka:
"\t</linearGradient>"

Wewnątrz klasy zdefiniuj klasę Builder. W klasie Builder stwórz metodę, która przyjmuje offset i kolor, a której wielokrotne wywołania pozwalają stworzyć tablicę tych wartości definiującą przebieg gradientu.

W metodzie toSvg klasy zewnętrznej wykorzystaj sformatowany napis:
"fill=\"url(#g%d)\" ", index

### [Rozwiązanie](https://github.com/tukarp/Object-Oriented-Programming/tree/main/Laboratoria/Lab%2003)

## Laboratorium 4 - Pliki, napisy, serializacja

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

### [Rozwiązanie](https://github.com/tukarp/Object-Oriented-Programming/tree/main/Laboratoria/Lab%2004)

## Laboratorium 5 - Wyjątki

### Zadanie 1

Utwórz interfejs PersonPersistenceManager implementujący metody load oraz save. Napisz dwie klasy implementujące te metody i przenieś do nich funkcjonalność napisanych wcześniej funkcji statycznych klasy Person:

- DirectoryPersonPersistenceManager: load = Person.fromDirectory, save = Person.toDirectory,

- CsvPersonPersistenceManager: load = Person.fromCsv, save = Person.toCsv.

Z wyjątkiem klasy Main, umieść wszystkie utworzone klasy w pakiecie “person” i zmodyfikuj potrzebne pola i metody z dostępem private na package tak, aby klasy *Manager miały do nich dostęp.

W czasie zajęć rozwijana będzie jedynie klasa DirectoryPersonPersistenceManager. Klasę CsvPersonPersistenceManager można zmodyfikować samodzielnie, aby uwzględniała zmiany wprowadzane w plikach.

### Zadanie 2

Rozważ sytuację, w której w dwóch plikach znajdują się osoby o tym samym imieniu i nazwisku. Utwórz wyjątek AmbigiousPersonException posiadający dwie metody zwracające ścieżki do tych plików. Wyjątek powinien być rzucany przez metodę DirectoryPersonPersistenceManager::load.

### Zadanie 3

Zmodyfikuj pliki tekstowe, aby pod dotychczasowymi liniami warunkowo znalazł się napis “Rodzice:”, a po nim w następnych liniach od 1 do 2 napisów definiujących inne osoby znajdujące się we wczytywanych plikach. Plik może być także pozbawiony informacji o rodzicach. Wówczas napis “Rodzice:” nie pojawia się.

Do klasy Person dodaj pole parents będące listą obiektów klasy Person. Pole to należy ustawić podczas tworzenia obiektów metodą PersonPersistenceManager::load.

### Zadanie 4

Rozważ sytuację, w której wiek osoby nie pozwala, aby była rodzicem innej. Napisz wyjątek ParentingAgeException. Wyjątek powinien posiadać dwa prywatne, statyczne pola minAge i maxAge o standardowych wartościach odpowiednio 10 i 100 oraz publiczne mutatory do tych pól. Wyjątek powinien być rzucany przez metodę PersonPersistenceManager::load, jeżeli rodzic w roku narodzin dziecka byłby młodszy niż minAge lub starszy niż maxAge.

### Zadanie 5

Niech klasa Person implementuje interfejs Serializable. Zdefiniuj klasę BinaryPersonPersistenceManager implementującą interfejs PersonPersistenceManager. Metoda save powinna zapisywać tablicę obiektów Person do pliku binarnego, a metoda load powinna ją zwracać.

### Zadanie 6

Zmodyfikuj pliki tekstowe, aby pod dotychczasowymi liniami warunkowo znalazł się napis “Dzieci:”, a po nim dowolna liczba linii napisów definiujących inne osoby znajdujące się we wczytywanych plikach. Do klasy Person dodaj pole children będące listą obiektów Person. Jeżeli osoba nie posiada dzieci, napis “Dzieci:” należy pominąć. Pole to należy ustawić podczas tworzenia obiektów metodą PersonPersistenceManager::load.

### Zadanie 7

Rozważ sytuację, w której rodzic lub dziecko zawiera imię i nazwisko osoby nie występującej w plikach. Napisz wyjątek UndefinedPersonReferenceException posiadający dwie metody: zwracającą plik, w którym doszło do błędu oraz zwracający imię i nazwisko osoby powodującej ten błąd.

### Zadanie 8

Rozważ sytuacje, w których:

- w pliku dziecka znajduje się rodzic, który nie posiada w swoim pliku tego dziecka,
- w pliku rodzica znajduje się dziecko, które nie podaje go jako swojego rodzica.

Zdefiniuj wyjątki ParentNotReferencingChildException oraz ChildNotReferencingParentException rzucane przez metodę DirectoryPersonPersistenceManager::load. Wyjątki te powinny dziedziczyć po klasie ParentChildInconsistencyException, której wyjątek należy przechwycić.

### [Rozwiązanie](https://github.com/tukarp/Object-Oriented-Programming/tree/main/Laboratoria/Lab%2005)

## Laboratorium 6 - Strumienie

### Zadanie 1

Utwórz klasę FileCommander przechowujący ścieżkę do katalogu w postaci prywatnego pola typu Path. Napisz konstruktor, który ustawia tą ścieżkę w katalogu domowym.

W klasie zdefiniuj metody publiczne:

- pwd, zwracającą napis zawierający aktualną ścieżkę,
- cd, przyjmującą ścieżkę i zmieniającą tą ścieżkę względem dotychczas aktualnej.

### Zadanie 2

W klasie FileCommander napisz metodę ls, która zwraca listę napisów zawierających nazwy plików i katalogów w aktualnej ścieżce. Następnie, krok po kroku, zmodyfikuj tą metodę tak, aby:

- wyniki zostały posortowane alfabetycznie,
- nazwy katalogów były otoczone znakami [ ],
- wyniki zostały posortowane tak, aby katalogi były przed plikami,
- wyniki zostały posortowane tak, aby katalogi były przed plikami, a dodatkowo obie grupy były posortowane alfabetycznie.

### Zadanie 3

W klasie FileCommander napisz metodę find, która przyjmie argument napisowy. Metoda powinna zwrócić listę napisów zawierających pełne ścieżki wszystkich plików, które znajdują się w aktualnej ścieżce i zawierają w nazwie podany argument.

### Zadanie 4

Napisz klasę FileCommanderCLI, która przyjmie jako parametry konstruktora strumień wejściowy i strumień wyjściowy. Konstruktor powinien utworzyć obiekt klasy FileCommander i przechowywać go w prywatnym polu klasy. Klasa powinna posiadać dwie metody:

- publiczną, bezargumentową eventLoop, w której ze strumienia wejściowego pobierane są linie napisów. Metoda ta powinna wywoływać kolejną metodę:
- prywatną, runCommand, przyjmującą pobraną linię, interpretującą ją jako wywołanie jednej z funkcjonalności klasy FileCommander, tj., pwd, cd <argument>, ls, find <argument>. Metoda ta powinna wywołać odpowiednią metodę obiektu FileCommander i wyświetlić listę wynikową na strumieniu wejściowym. Do rozróżnienia między poleceniami użyj instrukcji switch.

Utwórz obiekt klasy FileCommanderCLI przekazując mu jako parametry standardowe strumienie wejścia i wyjścia.

### Zadanie 5

Zmodyfikuj wywołanie funkcjonalności "ls" tak, aby można było go wywołać z opcją "--color". Katalogi powinny wówczas nie być otoczone nawiasami ale mieć kolor niebieski. W tym celu zmodyfikuj metodę FileCommander::ls, aby przyjmowała obiekt funkcyjny Function<String, String>. Napisz dwie metody, które będzie można przekazać takim parametrem: jedną dodającą nawiasy, a drugą zmieniającą kolor. Skorzystaj z  dołączonej klasy ConsoleColors.

### Zadanie 6

Zmodyfikuj wywołanie funkcjonalności "ls" tak, aby można było go wywołać z opcją "--filter=", gdzie po znaku równości może pojawić się dowolny ciąg znaków. Metoda FileCommander::ls powinna przyjmować ten napis jako parametr i zwracać wyłącznie pliki i katalogi zawierające ten napis.

Jeżeli opcje filter i color zostaną użyte jednocześnie, podciąg z filtra powinien być w nazwach plików i katalogów wyróżniony kolorem czerwonym.

### [Rozwiązanie](https://github.com/tukarp/Object-Oriented-Programming/tree/main/Laboratoria/Lab%2006)

## Laboratorium 7 - Programowanie generyczne

### Zadania 1

Napisz klasę szablonową CustomList implementującą strukturę listy jednokierunkowej ze wskaźnikami na początek i koniec. Zaprogramuj w niej metody:

- void addLast(T value) - dodającą wartość na koniec listy,
- T getLast() - zwracającą wartość z końca listy,
- void addFirst(T value) - dodającą wartość na początek listy,
- T getFirst() - zwracającą wartość z początku listy,
- T removeFirst() - zwracającą i usuwającą element z początku listy,
- T removeLast() - zwracającą i usuwającą element z końca listy.

### Zadanie 2

Niech klasa CustomList dziedziczy po klasie AbstractList. Wygeneruj potrzebne metody.  Nadpisz i zaprogramuj metody:

- boolean add(T t) - działającą tak samo jak addLast i zwracającą prawdę,
- int size() - zwracającą rozmiar listy,
- T get(int index) - zwracającą wartość w węźle o podanym indeksie.

### Zadanie 3

Nadpisz i zaprogramuj metody:

- Iterator<T> iterator() - zwracającą iterator do listy. Zdefiniuj w niej iterator,
- Stream<T> stream() - zwracającą strumień z zawartością listy.

### Zadanie 4

Napisz statyczną metodę szablonową, która przyjmie jako parametry Listę obiektów typu szablonowego T oraz obiekt Class. Metoda powinna zwrócić listę obiektów, które należą do wskazanej klasy.

Następnie zmodyfikuj metodę tak, aby filtrowała obiekty, które dziedziczą (bezpośrednio lub pośrednio) po wskazanej klasie.

### Zadanie 5

Napisz predykat, który porówna, czy testowana zmienna znajduje się w otwartym przedziale, zdefiniowanym jego granicami.

Korzystając z niego napisz metodę statyczną, która dla listy oraz granic zakresu danych typem szablonowym zwróci liczbę elementów w tej liście, spełniających warunek predykatu.

### Zadanie 6

Napisz komparator, który porówna dwie kolekcje pod względem liczby ich elementów. Następnie zmodyfikuj go tak, aby przyjmował wyłącznie kolekcje liczb i porównywał je pod względem ich sumy.

### [Rozwiązanie](https://github.com/tukarp/Object-Oriented-Programming/tree/main/Laboratoria/Lab%2007)

## Laboratorium 8 - Powtórzenie 1

### Zadanie 1

Napisz klasę DeathCauseStatistic, posiadającą jako prywatne pola kod ICD-10 choroby oraz tablicę liczb zgonów w kolejnych grupach wiekowych.

Napisz publiczną, statyczną metodę fromCsvLine zwracającą obiekt DeathCauseStatistic na podstawie pojedynczej linii pliku CSV. Uwzględnij, że w pliku po nazwie kodu znajduje się tabulator.

Napisz akcesor do kodu ICD-10 przyczyny zgonu.

### Zadanie 2

Wewnątrz klasy DeathCauseStatistic zdefiniuj publiczną klasę AgeBracketDeaths posiadającą publiczne, ostateczne pola typu int: young, old, deathCount zawierające granice grupy wiekowej i liczbę zgonów.

W klasie DeathCauseStatistic napisz metodę przyjmującą wiek i zwracającą obiekt AgeBracketDeaths odpowiadający temu wiekowi.

### Zadanie 3

Napisz klasę DeathCauseStatisticList, wewnątrz której, w wybranej strukturze danych przetrzymywana będzie informacja o wszystkich obiektach DeathCauseStatistic. Napisz metodę repopulate, przyjmującą ścieżkę do pliku, która usuwa istniejące dane z tej struktury i zapełnia ją danymi z pliku CSV.

W klasie DeathCauseStatisticsList napisz metodę mostDeadlyDiseases, która przyjmie wiek oraz liczbę n, mniejszą od liczby wymienionych chorób. Metoda powinna zwrócić n-elementową listę referencji na obiekty DeathCauseStatistic odpowiadające chorobom powodującym największą liczbę zgonów w grupie wiekowej do której przynależy podany wiek. Lista powinna być posortowana malejąco.

### Zadanie 4

Napisz interfejs ICDCodeTabular posiadający jedną, publiczną metodę getDescription, która dla podanego kodu choroby zwróci jej opis, lub gdy takiego kodu nie odnajdzie rzuci wyjątek IndexOutOfBoundsException. Zaimplementuj ten interfejs w dwóch klasach ICDCodeTabularOptimizedForTime oraz ICDCodeTabularOptimizedForMemory.

Klasa ICDCodeTabularOptimizedForTime powinna jednorazowo załadować wszystkie kody i opisy z pliku, a jej metoda getDescription powinna zwracać wartości z wybranej struktury danych w pamięci tymczasowej.

Klasa ICDCodeTabularOptimizedForMemory nie powinna przetrzymywać danych w pamięci operacyjnej, ale za każdym wywołaniem metody getDescription powinna otwierać plik i wyszukiwać w nim opisu.

### [Rozwiązanie](https://github.com/tukarp/Object-Oriented-Programming/tree/main/Laboratoria/Lab%2008)

## Laboratorium 9 - Testy

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

### [Rozwiązanie](https://github.com/tukarp/Object-Oriented-Programming/tree/main/Laboratoria/Lab%2009)

## Laboratorium 10 - Aplikacje sieciowe

### Zadanie 1

Napisz serwer czatu sieciowego. Serwer powinien pozwolić dołączyć dowolnej liczbie użytkowników. Serwer powinien oczekiwać na wiadomość od dowolnego użytkownika i rozsyłać tę wiadomość wszystkim użytkownikom.

### Zadanie 2

Napisz klienta czatu sieciowego współpracującego z napisanym serwerem. Klient powinien odczytywać standardowe wejście i przesyłać je do serwera oraz odbierać wiadomości z serwera i wyświetlać je na standardowym wyjściu.

### Zadanie 3a

Niech działanie klienta rozpoczyna się zawsze od wpisania loginu. Login powinien zostać przesłany serwerowi w postaci sformatowanej wiadomości. Zakładamy, że użytkownicy podadzą unikalne loginy. W chwili zalogowania pozostali użytkownicy czata powinni otrzymać informację o dołączeniu użytkownika, a chwili wyłączenia klienta o opuszczeniu przez niego czatu.

### Zadanie 3b

Jeżeli użytkownik wpisze “/online”, powinien otrzymać listę aktualnie zalogowanych użytkowników.

### Zadanie 4a

Niech wszystkie wiadomości użytkowników w czacie rozpoczynają się od ich loginów.

### Zadanie 4b

Jeżeli użytkownik napisze w czacie “/w recipient message”, gdzie recipient jest loginem odbiorcy, a message wysłaną wiadomością, należy przesłać tą wiadomość wyłącznie wybranemu odbiorcy. Jeżeli nie jest on zalogowany, należy wyświetlić nadawcy stosowną informację.

### Zadanie 5

Jeżeli użytkownik napisze w czacie “/file recipient path", gdzie recipient jest loginem odbiorcy, a path ścieżką do pliku, należy przesłać ten plik odbiorcy. Podczas przesyłania należy prezentować aktualny, procentowy, postęp kopiowania. Jeżeli odbiorca nie jest zalogowany, należy wyświetlić nadawcy stosowną informację.

### [Rozwiązanie](https://github.com/tukarp/Object-Oriented-Programming/tree/main/Laboratoria/Lab%2010)

## Laboratorium 11 - Graficzny interfejs użytkownika

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

Obsłuż wyświetlanie listy użytkowników. Podczas logowania klient powinien poprosić serwer o wysłanie mu aktualnej listy. Login i logout broadcast powinny dodawać i usuwać użytkownika z listy.

### Zadanie 5

Do głównego okna dodaj obiekt klasy ProgressBar. Zaprogramuj przycisk wysyłania pliku, jak aby otwierał dialog wyboru plików. Zaprogramuj przesyłanie pliku aktywnemu użytkownikowi z listy. Postęp przesyłania należy wyświetlić w kliencie otrzymującym plik.

### [Rozwiązanie](https://github.com/tukarp/Object-Oriented-Programming/tree/main/Laboratoria/Lab%2011)

## Laboratorium 12 - Gra

### Zadanie 1

Utwórz obiekt GameCanvas dziedziczący po javafx.scene.canvas.Canvas. W klasie tej znajdzie się logika i wyświetlanie pisanej gry.

W klasie GameCanvas utwórz prywatny obiekt klasy javafx.scene.canvas.GraphicsContext.

Napisz publiczną metodę draw(), w której będzie on wypełniał całą powierzchnię kanwy kolorem czarnym. Usuń wygenerowany plik FXML i powiązaną z nim klasę kontrolera. Zaprogramuj aplikację tak, aby wyświetlała obiekt GameCanvas.

### Zadanie 2

Zdefiniuj abstrakcyjną klasę GraphicsItem posiadającą chronione, statyczne pola canvasWidth, canvasHeight, oraz publiczny setter do nich. Pola te posłużą do przeliczania rzeczywistego rozmiaru kanwy na przedział 0 - 1. W klasie powinny znaleźć się także chronione, zmiennoprzecinkowe pola x, y, width i height oraz publiczne akcesory do nich.

Klasa powinna posiadać czysto wirtualną metodę draw(), przyjmującą GraphicsContext jako argument.

Napisz klasę Paddle, która dziedziczy po GraphicsItem i reprezentuje platformę, od której odbija się piłka. Utwórz w niej bezargumentowy konstruktor, który ustawi pozycję platformy w dolnej części ekranu. Zaimplementuj metodę draw tak, aby rysowała prostokąt wybranego koloru w pozycji odpowiadającej położeniu platformy.

W klasie GameCanvas przechwyć zdarzenie przesunięcia myszy. W klasie Paddle napisz metodę, która przyjmie x-ową składową zdarzenia i ustawi platformę tak, aby jej środek znajdował się pozycji tej składowej.

### Zadanie 3

Napisz klasę Ball, która dziedziczy po GraphicsItem i reprezentuje piłkę. Napisz w niej publiczną metodę setPosition(), która przyjmie obiekt javafx.geometry.Point2D i ustawi tam środek piłki.

W klasie prywatny obiekt Point2D moveVector, który będzie określał znormalizowany wektor ruchu. Ustaw go tak, aby piłka początkowo kierowała się pod kątem 45 stopni w prawo. Utwórz także prywatne pole double velocity określające z jaką szybkością będzie odbywał się ruch.

Napisz publiczną metodę updatePosition(), która na podstawie danych obliczy położenie piłki w następnym kroku.

Zaimplementuj metodę draw() tak, aby rysowała białe koło.

W klasie GameCanvas stwórz zmienną logiczną odpowiadającą za informowanie o trwaniu gry. Póki gra nie jest rozpoczęta, pozycja piłki powinna być powiązana z platformą i ustawiana przez setPosition(), a po jej rozpoczęciu przez updatePosition(). Grę powinien rozpoczynać przycisk myszy.

### Zadanie 4

W klasie GameCanvas utwórz obiekt AnimationTimer. Do jego metody handle() przenieś rysowanie zawartości kanwy. Zmodyfikuj metodę Ball.updatePosition tak, aby przyjmowała liczbę sekund, które minęły od ostatniej klatki.

### Zadanie 5

W klasie GameCanvas napisz metody prywatne shouldBallBounceHorizontally(), shouldBallBounceVertically() oraz shouldBallBounceFromPaddle(), wszystkie zwracające wartość logiczną, a sprawdzające warunek opisany swoim identyfikatorem.

W klasie Ball napisz metody publiczne  bounceHorizontally() i bounceVertically() modyfikujące wektor ruchu. Wywołaj te metody, jeżeli zostaną spełnione warunki. Odbicie od platformy potraktuj jako poziome.

### Zadanie 6

Napisz klasę Brick, która dziedziczy po GraphicsItem i reprezentuje jedną z cegieł. W klasie tej utwórz statyczne, prywatne pola gridRows i gridCols. Wyobrażona siatka ma podzielić cały dostępny ekran na równe prostokąty. Cegła będzie mogła znaleźć się w pojedynczej pozycji siatki. Napisz metodę ustawiającą te pola.

Napisz konstruktor, w którym przekazane zostaną całkowite pozycje x i y na siatce oraz kolor. Zaimplementuj metodę draw, tak aby rysunek symbolizował trójwymiarowość cegły.

W klasie GameCanvas stwórz listę obiektów Brick oraz metodę loadLevel, która ustawi siatkę na 20 wierszy i 10 kolumn, a wiersze od 2 do 7 zapełni cegłami, każdy wiersz w innym kolorze.

### Zadanie 7 

W klasie Ball napisz publiczne metody zwracające jej skrajne punkty: górny, dolny, lewy i prawy.

W klasie Brick zdefiniuj publiczny typ wyliczeniowy CrushType {NoCrush, HorizontalCrush, VerticalCrush}. Napisz metodę, która przyjmie cztery punkty zwrócone przez Ball i na ich podstawie stwierdzi, czy powinna ona rozbić cegłę, a jeżeli tak, to w jaki sposób. Powiąż odpowiedź z tej funkcji z odpowiednim sposobem odbicia piłki.

### Zadanie 8

W klasie Ball napisz metodę bounceFromPaddle, która przyjmie zmiennoprzecinkowy parametr. Parametr ten powinien być proporcjonalny do odległości pozycji uderzenia piłki od środka platformy i powinien posłużyć do obliczenia zmodyfikowanego wektora ruchu tak, aby uderzenie bliżej końców powodowało ruch pod większym kątem.

### [Rozwiązanie](https://github.com/tukarp/Object-Oriented-Programming/tree/main/Laboratoria/Lab%2012)

## Laboratorium 13 - Bazy danych

Utwórz bazę SQLite składającą się z pojedynczej tabeli:

```
CREATE TABLE person (
id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
first_name TEXT NOT NULL,
last_name TEXT NOT NULL
);
```

Zapełnij tę tabelę przykładowymi danymi.

### Zadanie 1

Napisz klasę DatabaseConnection posiadającą prywatne, statyczne pole typu java.sql.Connection. Napisz publiczny, statyczny akcesor do tego pola oraz publiczne, statyczne metody connect() i disconnect() nawiązujące i zrywające połączenie z bazą danych.


### Zadanie 2

Napisz klasę Person posiadającą pola analogiczne do kolumn tabeli. Napisz konstruktor ustawiający te pola oraz funkcje toString(). Napisz publiczną, statyczną metodę, która odczyta z bazy i zwróci w postaci listy obiektów Person całą zawartość tabeli.

### Zadanie 3

W klasie Person napisz publiczną, statyczną metodę, która przyjmie napis. Metoda powinna zwrócić listę obiektów Person zawierających dane z tablicy, których pole last_name jest równe przekazanemu parametrowi.

Napisz kolejną, podobną metodę, która zwróci osoby, których nazwisko rozpoczyna się od danego argumentem podciągu.

### Zadanie 4

W klasie Person napisz publiczną, statyczną metodę, która przyjmie napisy: firstName i lastName i utworzy w tabeli nowy wiersz z tymi polami.

Napisz podobną metodę, która zadziała w taki sam sposób, ale dodatkowo zwróci id, który został utworzony dla nowego wiersza.

Do samodzielnego zaprogramowania metody modyfikujące i usuwające wiersze.

### Zadanie 5

Korzystając ze strony https://start.spring.io/ utwórz projekt, w którym jako zależności wskazane zostaną Spring Web i Thymleaf. Następnie zaimportuj go w IDE. Utwórz klasę będącą kontrolerem wyświetlanych treści oraz odpowiadającą mu stronę HTML. Przetestuj wyświetlanie wartości zmiennych.

### Zadanie 6

Do utworzonego projektu dodaj klasy DatabaseConnection i Person. Zmodyfikuj stronę tak, aby wyświetlała wszystkie obiekty Person zwrócone przez funkcję napisaną w zadaniu 2.

### Zadanie 7

Do strony dodaj formularz składający się z dwóch pól: imię i nazwisko oraz przycisku. Po naciśnięciu przycisku dane z formularza należy dodać jako kolejny wiersz do tabeli w bazie i wyświetlić na stronie.

### [Rozwiązanie](https://github.com/tukarp/Object-Oriented-Programming/tree/main/Laboratoria/Lab%2013)

## Laboratorium 14 - Powtórzenie 2

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
CREATE TABLE dot(
id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
x INTEGER NOT NULL,
y INTEGER NOT NULL,
color TEXT NOT NULL,
radius INTEGER NOT NULL
);

Niech serwer, w momencie wystartowania łączy się z tą bazą. Wewnątrz serwera zdefiniuj metodę saveDot(), przyjmującą obiekt Dot, która zapisuje jego zawartość w bazie.
Napisz metodę getSavedDots(), która zwraca wszystkie zapisane koła w postaci listy Dot. Niech metoda broadcast() zapisuje koło do bazy. Chwilę po dołączeniu nowego klienta, należy mu przesłać wszystkie wygenerowane okręgi. Utwórz pomocniczą, niestatyczną metodę klasy Dot, generującą wiadomość na postawie parametrów koła zawartych w obiekcie.

### [Rozwiązanie](https://github.com/tukarp/Object-Oriented-Programming/tree/main/Laboratoria/Lab%2014)
