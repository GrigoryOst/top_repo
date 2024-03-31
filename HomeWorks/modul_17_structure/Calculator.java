package HomeWorks.modul_17_structure;

/*2. Декоратор:
        - Реализуйте декоратор LoggerDecorator, который добавляет логирование каждого вызова метода базового класса Calculator.
        Логирование должно выводить информацию о вызываемом методе и его аргументах.
        - Реализуйте декоратор EncryptionDecorator, который добавляет шифрование каждого возвращаемого значения метода базового класса Database.
        Шифрование должно использовать некоторый алгоритм шифрования, например, AES.*/

// Базовый класс калькулятора
class Calculator {
    // Метод для выполнения сложения
    public int add(int a, int b) {
        return a + b;
    }

    // Метод для выполнения вычитания
    public int subtract(int a, int b) {
        return a - b;
    }
}

// Декоратор для добавления логирования
class LoggerDecorator extends Calculator {
    private Calculator calculator;

    // Конструктор декоратора
    public LoggerDecorator(Calculator calculator) {
        this.calculator = calculator;
    }

    // Переопределенный метод сложения с логированием
    @Override
    public int add(int a, int b) {
        System.out.println("Вызов метода add с аргументами: " + a + " и " + b);
        return calculator.add(a, b);
    }

    // Переопределенный метод вычитания с логированием
    @Override
    public int subtract(int a, int b) {
        System.out.println("Вызов метода subtract с аргументами: " + a + " и " + b);
        return calculator.subtract(a, b);
    }
}

// Базовый класс базы данных
class Database {
    // Метод для получения данных
    public String getData() {
        return "raw data";
    }
}

// Декоратор для добавления шифрования
class EncryptionDecorator extends Database {
    private Database database;

    // Конструктор декоратора
    public EncryptionDecorator(Database database) {
        this.database = database;
    }

    // Переопределенный метод получения данных с шифрованием
    @Override
    public String getData() {
        String rawData = database.getData();
        System.out.println("Шифрование данных");
        // Здесь должен быть код для шифрования данных, например, с использованием AES
        return encrypt(rawData);
    }

    // Метод для шифрования данных (примерная реализация)
    private String encrypt(String data) {
        // Здесь должен быть алгоритм шифрования
        return "encrypted " + data;
    }
}
