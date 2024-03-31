package HomeWorks.modul_17_structure;

/*1. Адаптер:
        - Реализуйте адаптер для класса Square, который имеет метод calculateArea() для вычисления площади квадрата,
        чтобы он мог использовать метод calculateArea() класса Rectangle, который принимает длину и ширину и возвращает площадь прямоугольника.
        - Реализуйте адаптер для класса CSVReader, который имеет метод readData(),
        чтобы он мог использовать метод parseData() класса XMLReader, который парсит XML-данные и возвращает результат в формате CSV.*/

// Класс квадрата с методом вычисления площади
class Square {
    private double side;

    // Конструктор класса Square
    public Square(double side) {
        this.side = side;
    }

    // Метод для вычисления площади квадрата
    public double calculateArea() {
        return side * side;
    }
}

// Класс прямоугольника с методом вычисления площади
class Rectangle {
    // Метод для вычисления площади прямоугольника
    public double calculateArea(double length, double width) {
        return length * width;
    }
}

// Адаптер для класса Square, чтобы использовать метод calculateArea класса Rectangle
class SquareAdapter {
    private Square square;

    // Конструктор адаптера
    public SquareAdapter(Square square) {
        this.square = square;
    }

    // Адаптированный метод вычисления площади
    public double calculateArea() {
        Rectangle rectangle = new Rectangle();
        // Вызов метода calculateArea класса Rectangle для квадрата
        return rectangle.calculateArea(square.calculateArea(), 1);
    }
}

// Класс для чтения данных в формате CSV
class CSVReader {
    // Метод для чтения данных
    public String readData() {
        System.out.println("Чтение данных в формате CSV");
        return "data in CSV format";
    }
}

// Класс для парсинга XML данных
class XMLReader {
    // Метод для парсинга XML и возврата данных в формате CSV
    public String parseData() {
        System.out.println("Парсинг XML и преобразование в CSV");
        return "parsed data in CSV format";
    }
}

// Адаптер для класса CSVReader, чтобы использовать метод parseData класса XMLReader
class CSVAdapter {
    private XMLReader xmlReader;

    // Конструктор адаптера
    public CSVAdapter(XMLReader xmlReader) {
        this.xmlReader = xmlReader;
    }

    // Адаптированный метод чтения данных
    public String readData() {
        // Вызов метода parseData класса XMLReader
        return xmlReader.parseData();
    }
}
