# Laboratorium 12

## Gra

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

W klasie Ball napisz metody publiczne bounceHorizontally() i bounceVertically() modyfikujące wektor ruchu. Wywołaj te metody, jeżeli zostaną spełnione warunki. Odbicie od platformy potraktuj jako poziome.

### Zadanie 6

Napisz klasę Brick, która dziedziczy po GraphicsItem i reprezentuje jedną z cegieł. W klasie tej utwórz statyczne, prywatne pola gridRows i gridCols. Wyobrażona siatka ma podzielić cały dostępny ekran na równe prostokąty. Cegła będzie mogła znaleźć się w pojedynczej pozycji siatki. Napisz metodę ustawiającą te pola.

Napisz konstruktor, w którym przekazane zostaną całkowite pozycje x i y na siatce oraz kolor. Zaimplementuj metodę draw, tak aby rysunek symbolizował trójwymiarowość cegły.

W klasie GameCanvas stwórz listę obiektów Brick oraz metodę loadLevel, która ustawi siatkę na 20 wierszy i 10 kolumn, a wiersze od 2 do 7 zapełni cegłami, każdy wiersz w innym kolorze.

### Zadanie 7 

W klasie Ball napisz publiczne metody zwracające jej skrajne punkty: górny, dolny, lewy i prawy.

W klasie Brick zdefiniuj publiczny typ wyliczeniowy CrushType {NoCrush, HorizontalCrush, VerticalCrush}. Napisz metodę, która przyjmie cztery punkty zwrócone przez Ball i na ich podstawie stwierdzi, czy powinna ona rozbić cegłę, a jeżeli tak, to w jaki sposób. Powiąż odpowiedź z tej funkcji z odpowiednim sposobem odbicia piłki.

### Zadanie 8

W klasie Ball napisz metodę bounceFromPaddle, która przyjmie zmiennoprzecinkowy parametr. Parametr ten powinien być proporcjonalny do odległości pozycji uderzenia piłki od środka platformy i powinien posłużyć do obliczenia zmodyfikowanego wektora ruchu tak, aby uderzenie bliżej końców powodowało ruch pod większym kątem.
