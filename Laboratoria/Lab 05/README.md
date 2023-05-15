# Laboratorium 5 

## Wyjątki

### Zadanie 1

Utwórz interfejs ```PersonPersistenceManager``` implementujący metody ```load``` oraz ```save```. Napisz dwie klasy implementujące te metody i przenieś do nich funkcjonalność napisanych wcześniej funkcji statycznych klasy ```Person```:

- ```DirectoryPersonPersistenceManager```: load = Person.fromDirectory, save = Person.toDirectory,

- ```CsvPersonPersistenceManager```: load = Person.fromCsv, save = Person.toCsv.

Z wyjątkiem klasy ```Main```, umieść wszystkie utworzone klasy w pakiecie ```person``` i zmodyfikuj potrzebne pola i metody z dostępem private na package tak, aby klasy ```Manager``` miały do nich dostęp.

W czasie zajęć rozwijana będzie jedynie klasa ```DirectoryPersonPersistenceManager```. Klasę ```CsvPersonPersistenceManager``` można zmodyfikować samodzielnie, aby uwzględniała zmiany wprowadzane w plikach.

### Zadanie 2

Rozważ sytuację, w której w dwóch plikach znajdują się osoby o tym samym imieniu i nazwisku. Utwórz wyjątek ```AmbigiousPersonException``` posiadający dwie metody zwracające ścieżki do tych plików. Wyjątek powinien być rzucany przez metodę ```DirectoryPersonPersistenceManager::load```.

### Zadanie 3

Zmodyfikuj pliki tekstowe, aby pod dotychczasowymi liniami warunkowo znalazł się napis ```Rodzice:```, a po nim w następnych liniach od 1 do 2 napisów definiujących inne osoby znajdujące się we wczytywanych plikach. Plik może być także pozbawiony informacji o rodzicach. Wówczas napis “Rodzice:” nie pojawia się.

Do klasy ```Person``` dodaj pole parents będące listą obiektów klasy ```Person```. Pole to należy ustawić podczas tworzenia obiektów metodą ```PersonPersistenceManager::load```.

### Zadanie 4

Rozważ sytuację, w której wiek osoby nie pozwala, aby była rodzicem innej. Napisz wyjątek ```ParentingAgeException```. Wyjątek powinien posiadać dwa prywatne, statyczne pola ```minAge``` i ```maxAge``` o standardowych wartościach odpowiednio ```10``` i ```100``` oraz publiczne mutatory do tych pól. Wyjątek powinien być rzucany przez metodę ```PersonPersistenceManager::load```, jeżeli rodzic w roku narodzin dziecka byłby młodszy niż ```minAge``` lub starszy niż ```maxAge```.

### Zadanie 5

Niech klasa ```Person``` implementuje interfejs ```Serializable```. Zdefiniuj klasę ```BinaryPersonPersistenceManager``` implementującą interfejs ```PersonPersistenceManager```. Metoda ```save``` powinna zapisywać tablicę obiektów ```Person``` do pliku binarnego, a metoda ```load``` powinna ją zwracać.

### Zadanie 6

Zmodyfikuj pliki tekstowe, aby pod dotychczasowymi liniami warunkowo znalazł się napis ```Dzieci:```, a po nim dowolna liczba linii napisów definiujących inne osoby znajdujące się we wczytywanych plikach. Do klasy ```Person``` dodaj pole ```children``` będące listą obiektów ```Person```. Jeżeli osoba nie posiada dzieci, napis ```Dzieci:``` należy pominąć. Pole to należy ustawić podczas tworzenia obiektów metodą ```PersonPersistenceManager::load```.

### Zadanie 7

Rozważ sytuację, w której rodzic lub dziecko zawiera imię i nazwisko osoby nie występującej w plikach. Napisz wyjątek ```UndefinedPersonReferenceException``` posiadający dwie metody: zwracającą plik, w którym doszło do błędu oraz zwracający imię i nazwisko osoby powodującej ten błąd.

### Zadanie 8

Rozważ sytuacje, w których:

- w pliku dziecka znajduje się rodzic, który nie posiada w swoim pliku tego dziecka,
- w pliku rodzica znajduje się dziecko, które nie podaje go jako swojego rodzica.

Zdefiniuj wyjątki ```ParentNotReferencingChildException``` oraz ```ChildNotReferencingParentException``` rzucane przez metodę ```DirectoryPersonPersistenceManager::load```. Wyjątki te powinny dziedziczyć po klasie ```ParentChildInconsistencyException```, której wyjątek należy przechwycić.
