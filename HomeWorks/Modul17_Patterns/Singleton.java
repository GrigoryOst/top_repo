package HomeWorks.Modul17_Patterns;

public class Singleton {
    private static Singleton instance; // Приватный статический экземпляр класса Student
    private Singleton() {
        // Приватный конструктор
    }

    public static Singleton getInstance() {
        if (instance == null) { // Проверка, создан ли уже экземпляр класса
            instance = new Singleton(); // Создание экземпляра класса
        }
        return instance; // Возвращение экземпляра класса
    }
}
