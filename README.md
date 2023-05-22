# Programowanie Obiektowe

## Spis treści

### Laboratoria

- [Lab 01 - Klasa i obiekt](https://github.com/tukarp/Object-Oriented-Programming/blob/main/Laboratoria/Lab%2001/)
- [Lab 02 - paradygmaty programowania obiektowego](https://github.com/tukarp/Object-Oriented-Programming/blob/main/Laboratoria/Lab%2002)
- [Lab 03 - Wzorce projektowe](https://github.com/tukarp/Object-Oriented-Programming/blob/main/Laboratoria/Lab%2003)
- [Lab 04 - Pliki, napisy, serializacja](https://github.com/tukarp/Object-Oriented-Programming/blob/main/Laboratoria/Lab%2004)
- [Lab 05 - Wyjątki](https://github.com/tukarp/Object-Oriented-Programming/blob/main/Laboratoria/Lab%2005)
- [Lab 06 - Strumienie](https://github.com/tukarp/Object-Oriented-Programming/blob/main/Laboratoria/Lab%2006)
- [Lab 07 - Programowanie generyczne](https://github.com/tukarp/Object-Oriented-Programming/blob/main/Laboratoria/Lab%2007)
- [Lab 08 - Powtórzenie 1](https://github.com/tukarp/Object-Oriented-Programming/blob/main/Laboratoria/Lab%2008)
- [Lab 09 - Testy](https://github.com/tukarp/Object-Oriented-Programming/blob/main/Laboratoria/Lab%2009)
- [Lab 10 - Aplikacje sieciowe](https://github.com/tukarp/Object-Oriented-Programming/blob/main/Laboratoria/Lab%2010)
- [Lab 11 - Graficzny interfejs użytkownika](https://github.com/tukarp/Object-Oriented-Programming/blob/main/Laboratoria/Lab%2011)
- [Lab 12 - Gra](https://github.com/tukarp/Object-Oriented-Programming/blob/main/Laboratoria/Lab%2012)
- [Lab 13 - Bazy danych](https://github.com/tukarp/Object-Oriented-Programming/blob/main/Laboratoria/Lab%2013)
- [Lab 14 - Powtórzenie 2](https://github.com/tukarp/Object-Oriented-Programming/blob/main/Laboratoria/Lab%2014)

### Notatki

- [Notatki](#notatki-1)
- [Teoria](#teoria)
    - [Wstęp](#wstęp)
    - [Obiekty i klasy - Zmienne i metody](#obiekty-i-klasy---zmienne-i-metody)
    - [Rodzaje zmiennych w klasie](#rodzaje-zmiennych-w-klasie)
    - [Akcesory i mutatory](#akcesory-i-mutatory)
    - [Chierarchie klas](#chierarchie-klas)
    - [Dziedziczenie](#dziedziczenie)
    - [Rodzaje obiektów](#rodzaje-obiektów)
    - [Paradygmaty programowania obiektowego](#paradygmaty-programowania-obiektowego)
- [Java](#java)
    - [Słowa kluczowe](#słowa-kluczowe)
    - [Operatory](#operatory)
    - [Typy](#typy)
    - [Zmienne](#zmienne)
    - [Instrukcje](instrukcje)
    - [Pętle](#pętle)
    - [Obiekty](#obiekty)
    - [Dziedziczenie i interfejsy](#dziedziczenie-i-interfejsy)
    - [Wyjątki](#wyjątki)
    - [Klasa wyjątku](#klasa-wyjątku)
    - [Klasy parametryzowane typami](#klasy-parametryzowane-typami)
    - [Kolekcje](#kolekcje)
    - [Klasa iteratora](#klasa-iteratora)
    - [Strumienie](#strumienie)
    - [Strumienie binarne](#strumienie-binarne)
    - [Graficzny interfejs użytkownika](#graficzny-interfejs-użytkownika)
    - [Najważniejsze rodzaje zdarzeń](#najważniejsze-rodzaje-zdarzeń)

# Notatki

## Teoria

### Wstęp

- ```Paradygmaty Programowania``` – to różne sposoby, w których dany program lub język programowania może być zorganizowany. Każdy paradygmat składa się z pewnych struktur, cech i opinii na temat tego, jak należy rozwiązywać typowe problemy programistyczne.

- ```Programowanie Obiektowe``` (ang. Object Oriented Programming) - to popularny paradygmat programowania, w którym modelujemy istniejącą rzeczywistość za pomocą obiektów, zamiast stosować tylko funkcje i logikę.

- ```Sprzężenie``` - jest miarą jak bardzo obiekty, podsystemy lub systemy zależą od siebie nawzajem.

- ```Spójność``` (ang. cohesion) -  to miara jak funkcjonalnie powiązane są metody danej klasy.


### Obiekty i klasy - Zmienne i metody

- ```Zmienne Klasy``` - należą do całości klasy, jest tylko jedna kopia każdej.
- ```Instancje Zmiennych lub Atrybutów``` - dane, które należą do indywidualnych obiektów.
- ```Zmienne Składowe``` - odwołują się zarówno do klas, jak i zmiennych instancji.
- ```Metody w Klasach``` - należą do całości klas i mają dostęp tylko do zmiennych klas oraz wprowadzanych w wywoływaniu procedur.
- ```Metody Instancji``` - należą do indywidualnych obiektów, mają dostęp do zmiennych instancji dla specyficznych obiektów, dla których są wywoływane, wprowadzanych oraz zmiennych klas.

### Rodzaje zmiennych w klasie

- ```Publiczne``` (ang. public) - mogą ich bez ograniczeń używać obiekty wszystkich klas.
- ```Chronione``` (ang. protected) - mogą ich bez ograniczeń używać obiekty tej samej klasy lub jej podklas.
- ```Prywatne``` (ang. private) - mogą ich używać jedynie obiekty tej samej klasy.

### Akcesory i mutatory

- ```Akcesor``` (ang. getter) - metoda umożliwiająca dostęp do niepublicznej zmiennej danej klasy.
- ```Mutator``` (ang. setter) - metoda umożliwiająca modyfikację niepublicznej zmiennej danej klasy.

### Chierarchie klas

- ```Klasa Bazowa``` (ang. base class) - bądź inaczej nadklasa (ang. superclass) definiuje składowe wspólne dla wszystkich wariantów.
- ```Klasa Pochodna``` (ang. derived class / subclass) - definiują pozostałe składowe, które występują tylko w poszczególnych wariantach.
- ```Uogólnienie``` (ang. generalization) -  związek między nadklasą i podklasami.

### Dziedziczenie

- ```Dziedziczenie``` (ang. inheritance) - klasa pochodna dziedziczy wszystkie składowe klasy bazowej.
- ```Przedefiniowanie``` (ang. override) - klasa pochodna podaje nowe definicje metod nadklasy.
- ```Rozszerzenie``` (ang. extends) - ponieważ klasa może zawierać nowe składowe, często mówi się, że podklasa ```rozszerza``` nadklasę.

### Rodzaje obiektów

- ```Klasa``` - jest definicją obiektu posiadającego właściwości oraz operacje.
- ```Interfejs``` – jest definicją abstrakcyjnego typu posiadającego jedynie operacje, a nie właściwości.

### Paradygmaty programowania obiektowego

- ```Abstrakcja``` -  pewnego rodzaju uproszczenie rozpatrywanego problemu, polegające na ograniczeniu zakresu cech manipulowanych obiektów wyłącznie do cech kluczowych dla algorytmu, a jednocześnie niezależnych od implementacji.
- ```Hermetyzacja``` - polega na ukrywaniu pewnych danych składowych lub metod obiektów danej klasy tak, aby były one dostępne tylko metodom wewnętrznym danej klasy lub funkcjom zaprzyjaźnionym.
- ```Dziedziczenie``` -  mechanizm współdzielenia funkcjonalności między klasami. Klasa może dziedziczyć po innej klasie, co oznacza, że oprócz swoich własnych atrybutów oraz zachowań, uzyskuje także te pochodzące z klasy, z której dziedziczy.
- ```Polimorfizm``` - mechanizm pozwalający na używanie wartości, zmiennych i podprogramów na kilka różnych sposobów. Jest to możliwość wyabstrahowania wyrażeń od konkretnych typów.

## Java

### Słowa kluczowe

```abstract```  ```continue```	```for```	```new```	```switch```

```assert``` ```default```	```if```	```package```	```synchronized```

```boolean```	```do```	```goto```	```private```	```this```

```break```	```double```	```implements```	```protected```	```throw```

```byte```	```else```	```import```	```public```	```throws```

```case```	```enum```	```instanceof```	```return```	```transient```

```catch```	```extends```	```int```	```short```	```try```

```char```	```final```	```interface```	```static```	```void```

```class```	```finally```	```long```	```strictfp```	```volatile```

```const```	```float```	```native```	```super```	```while```

### Operatory

```=``` ```>```	```<```	```!```	```~```	```?``` ```:```

```==```    ```<=```	```>=```	```!=```	```&&```	```||```	```++```	```--```

```+```	```-```	```*```	```/```	```&```	```|```	```^```	```%```	```<<```	```>>```	```>>>```

```+=```	```-=```	```*=```	```/=```	```&=```	```|=```	```^=```	```%=```	```<<=```	```>>=```	```>>>=```

### Typy

- ```Pierwotne```
    - ```boolean``` - typ logiczny,
    - ```byte```, ```short```, ```int```, ```long```, ```char``` - typy całkowitoliczbowe,
    - ```float```, ```double``` - typy zmiennopozycyjne.
- ```Referencyjne```
    - ```class``` - typ klas,
    - ```interface``` - typ interfejsów,
    - ```array``` - typ tablic.

### Zmienne

- ```Zmienne```
    - ```Klasowe```,
    - ```Egzemplarzowe```,
    - ```Lokalne```,
- ```Elementy```
     - ```Tablicy (anonimowe)```,
- ```Parametry```
    - ```Metod```,
    - ```Konstruktorów```,
    - ```Obsługi wyjątków```.

### Instrukcje

Instrukcja ```return```
```
return;
```

Instrukcja ```break```
```
break;
```

Instrukcja ```continue```
```
continue;
```

Instrukcja deklaracji ```zmiennej lokalnej```
```
int x = 10;
```

Instrukcja deklaracji ```zmiennej tablicowej```
```
int[] array = new int[10]; 
```

Instrukcja zgłoszenia ```wyjątku```
```
throw new Exception();
```

Instrukcja ```assert```
```
assert x > 0;
assert x >= 0: "x (" + x + ") mniejsze od zera";
```

Instrukcja ```switch```
```
switch(x) {
    case -1: System.out.println(x - 1);
    case 0: System.out.println(x);
    case 1: System.out.println(x + 1);
    default: System.out.println(0);
}
```

Instrukcja warunkowa ```if```
```
if(x > 0) {
    System.out.println("X jest większe od 0!");
} else if(x==0){
    System.out.println("X jest równe 0!");
} else {
    System.out.println("X jest mniejsze od 0!");
}
```

Instrukcja ```try```
```
try {
    x = 10 / 0;
} catch (ArithmeticException e){
    System.out.println("Dzielenie przez zero");
} finally {
    System.out.println("Kończymy");
}
```

### Pętle

Pętla ```for```
```
for(int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

Pętla ```while```
```
int i = 0;
while(x < 10) {
    System.out.println(i);
    x++;
}
```

Pętla ```do```
```
int i = 0;
do {
    System.out.println(i);
    i++;
} while (i < 10);
```

### Obiekty

```Klasa```
```
class Person {
    private String name;
    private String surname;
    private int age;
}
```

```Interfejs```
```
abstract class Person {
    public void sayHello() {
        System.out.println("Hello");
    }
}
```

Definicja podstawowych metod ```klasy```
```
class Person {
    private String name;
    private String surname;
    private int age;

    void setName(String name) {
        this.name = name;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }

    void setAge(int age) {
        this.age = age;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    int getAge() {
        return age;
    }
}
```

Utworzenie obiektu ```klasy```
```
Person person = new Person("Jan", "Kowalski" 20);
```

### Dziedziczenie i interfejsy

Dziedziczenie po ```klasie```
```
class Cat extends Mammal
```

Dziedziczenie po ```interfejsie```
```
class Car implements Vehicle
```

Dziedziczenie po ```klasie``` i ```interfejsie```
```
class Coffe extends Drink implements Bitter
```

```super``` - służy do wywoływania metod nadklasy i uzyskiwania dostępu do konstruktora nadklasy.

### Wyjątki

Obsługa ```wyjątków```
```
try {
    // komenda która może zgłosić wyjątki
} catch (FirstException exception) {
    // obsługa wyjątków FirstException
} catch (SecondException exception) {
    // obsługa wyjątków SecondException
} catch (ThirdException exception) {
    // obsługa wyjątków ThirdException
} finally {
    // możliwe zwolnienie zasobów
}
```

### Klasa wyjątku

```Exception``` - tę klasę rozszerzamy tworząc własne rodzaje wyjątków.

Użycie ```klasy wyjątku```
```
class ExceptionOne extends Exception {}
```

Funkcja wyrzucająca ```wyjątek```
```
public static void main(String[] args) throws Exception {}
```

### Klasy parametryzowane typami

Definiujemy pojęcie pary jako ```typ uogólniony```

```
 public class Para<T1, T2> {
   private T1 first;
   private T2 second;
   public Para(T1 first, T2 second) {
     this.first = first;
     this.second = second;
   }

   public T1 first() {
     return first; 
   }
    
   public T2 second() {
     return second; 
   }
    
   public void first(T1 first) {
     this.first = first;
   }
    
   public void second(T2 second {
     this.second = second;
   }
 }
 ```

```Metoda parametryzowana typami``` - może występować w zwykłych klasach. Jej deklaracje poprzedzamy podaniem parametrów.

### Kolekcje

Interfejs Collection
```
public interface Collection<E> extends Iterable<E> {
    // ...
}
```

Sprawdzenie rozmiaru
```
boolean isEmpty()
```

```
int size()
```

Wstawianie elementów
```
boolean add(E e)
```

```
boolean addAll(Collection<? extends E> c)
```

Sprawdzanie zawartości
```
boolean contains(Object o)
```

```
boolean containsAll(Collection<?> c)
```

Usuwanie elementów
```
boolean remove(Object o)
```

```
boolean removeAll(Collection<?> c)
```

Petla ```for each```
```
for(type id : expression {
    instruction
}
```

### Klasa iteratora

```
public interface Iterator<E> {
    boolean hasNext();
    void remove();
    E next;
}
```

### Strumienie

```Dekorator``` - strukturalny wzorzec pozwalający na dodawanie obiektom nowych obowiązków w sposób dynamiczny — poprzez “opakowywanie” ich w specjalne obiekty posiadające potrzebną funkcjonalność.

```Strumienie``` (ang. stream) - są używane zarówno do wysyłania / zapisywania jak i pobierania / odczytywania porcji danych danych.

|     Podklasy InputStream i OutputStream       |     Podklasy Reader i Writer      |                             Opis                                |
| :-------------------------------------------: | :-------------------------------: | :-------------------------------------------------------------: |
|      FileInputStream i FileOutputStream       |      FileReader i FileWriter      |          Pozwalają odczytywać i zapisywać pliki dyskowe         |
|  ByteArrayInputStream i ByteArrayOutputStream | CharArrayReader i CharArrayWriter | Bufor w pamięci oparty na tablicy odpowiednio bajtów lub znaków |
|            StringBufferInputStream            |    StringReader i StringWriter    |           Bufor w pamięci oparty na napisie String              |
|      FileInputStream i FileOutputStream       |     PipedReader i PipedWriter     |             Łącze do komunikacji między procesami               |

### Strumienie binarne

| Strumienie Binarne                         |     Strumienie Znakowe          |                                                  Opis                                                         |
| :----------------------------------------: | :-----------------------------: | :-----------------------------------------------------------------------------------------------------------: |
| BufferedInputStream i BufferedOutputStream | BufferedReader i BufferedWriter |                                  Operacje na strumieniu stają się buforowane                                  |
|                 PrintStream                |           PrintWriter           |     Dodają wiele nowych metod pozwalających wypisywać do strumienia dane w sposób czytelny dla człowieka      |
|             PushBackInputStream            |         PushBackReader          |              Dodają nową metodę unread() pozwalającą odesłać z powrotem ostatnio odczytane dane               |
|           LineNumberInputStream            |        LineNumberReader         |              Dodają nową metodę getLineNumber(), która daje liczbę odczytanych do tej pory linii              |
|     DataInputStream i DataOutputStream     |               Brak              |       Dodają wiele nowych metod pozwalających przesyłać przez strumień wartości typów podstawowych Javy       |
|   ObjectInputStream i ObjectOutputStream   |               Brak              | Dodają nowe metody pozwalające przesyłać przez strumień obiekty implementujące interfejs java.io.Serializable |
|  CheckedInputStream i CheckedOutputStream  |               Brak              |                         Wylicza sumę kontrolną dla danych przesyłanych przez strumień                         |
|     GZIPInputStream i GZIPOutputStream     |               Brak              |              Dane przesyłane przez strumień są kompresowane przy pomocy prostego algorytmu GZIP               |
|      ZipInputStream i ZipOutputStream      |               Brak              |                   Dane przesyłane przez strumień są kompresowane przy pomocy algorytmu Zip                    |
|   CipherInputStream i CipherOutputStream   |               Brak              |        Dane przesyłane przez strumień są szyfrowane lub deszyfrowane przy pomocy obiektu klasy Cipher         |

### Graficzny interfejs użytkownika

- ```BorderLayout``` - główne kontenery (JApplet, JDialog i JFrame) domyślnie używają BorderLayout. Przy jego pomocy można rozmieścić do pięciu innych komponentów, w tym inne kontenery,
- ```FlowLayout``` - zmianę zarządcy układu wykonuje się przy pomocy metody setLayout(LayoutManager).
- ```GridLayout``` - układa komponenty w komórkach siatki, której rozmiar określamy przy pomocy parametrów konstruktora,
- ```BoxLayout``` - komponenty są umieszczane w jednym wierszu lub w jednej kolumnie, zagnieżdżając w sobie kontenery używające BoxLayout można uzyskać bardzo skomplikowane układy,
- ```GridBagLayout``` - rozbudowany zarządca dający bardzo duże możliwości zapanowania nad rozmieszczeniem komponentów, doskonale nadaje się używania przez graficzne narzędzia przeznaczone do budowanie GUI metodą przeciągnij i upuść,
- ```SpringLayout``` – rozmieszczenie komponentów jest kontrolowane przez definicje więzów, które wyznaczają pionową lub poziomą odległość między krawędziami dwóch komponentów,
- ```CardLayout``` – umożliwia proste przełączanie wyświetlanych komponentów w trakcie działania programu. Każdy komponent dodany do kontenera używającego CardLayout traktowany jest jak kartka.

### Najważniejsze rodzaje zdarzeń

| Interfejs obserwatora |             Metody             |                             Opis                             |
| :-------------------: | :----------------------------: | :----------------------------------------------------------: |
|    ActionListener     | actionPerformed(ActionEvent e) | Dotyczy komponentów różnego rodzaju. Zachodzi np. gdy użytkownik klika przycisk, zatwierdza enterem tekst wpisany do pola tekstowego lub wybiera pozycję z menu |
|     MouseListener     | mouseClicked(MouseEvent e), mouseEntered(MouseEvent e), mouseExited(MouseEvent e), mousePressed(MouseEvent e), mouseReleased(MouseEvent e) | Zdarzenia dotyczą operacji wykonywanych myszką na komponencie jak: wciśnięcie przycisku, puszczenie przycisku, kliknięcie |
|  MouseMotionListener  | mouseDragged(MouseEvent e), mouseMoved(MouseEvent e) | Zdarzenia dotyczą ruchów kursora myszy nad komponentem oraz ruchów kursora myszy podczas przytrzymywania przycisku |
|      KeyListener      | keyPressed(KeyEvent e), keyReleased(KeyEvent e), keyTyped(KeyEvent e) | Zdarzenia informujące o wciśnięciu, puszczeniu i kliknięciu klawisza na klawiaturze |
|     TextListener      | textValueChanged(TextEvent e)  | Dotyczy komponentów rozszerzających JTextComponent |
|    WindowListener     | windowActivated(WindowEvent e), windowClosed(WindowEvent e), windowClosing(WindowEvent e), windowDeactivated(WindowEvent e), windowDeiconified(WindowEvent e), windowIconified(WindowEvent e), windowOpened(WindowEvent e) | Zdarzenia dotyczące okien. Można m.in. zorientować się kiedy okno staje się/przestaje być aktywne, kiedy jest minimalizowane/przywracane do normalnego rozmiaru oraz kiedy jest otwierane po raz pierwszy/zamykane |

## Źródła

```
https://wazniak.mimuw.edu.pl
```

```
https://pl.wikipedia.org/
```

```
https://stormit.pl/programowanie-obiektowe/
```

```
https://refactoring.guru/
```
