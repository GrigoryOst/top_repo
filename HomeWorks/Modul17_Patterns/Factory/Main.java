package HomeWorks.Modul17_Patterns.Factory;


public class Main {
    /* Создайте класс FactoryMethod, реализующий паттерн Factory Method.
    У этого класса должен быть абстрактный метод createStudent(),
    который возвращает объект типа Student. Создайте два класса,
    реализующих интерфейс Student - UndergraduateStudent и GraduateStudent.
    Создайте класс StudentFactory, который наследуется от FactoryMethod и реализует его абстрактный метод.
    Проверьте работу паттерна, создав объект StudentFactory и вызывая его метод createStudent()
    для создания объектов UndergraduateStudent и GraduateStudent. */

    public static void main(String[] args) {
        // Создание объекта StudentFactory
        StudentFactory studentFactory = new StudentFactory();

        // Вызов метода createStudent() для создания объекта UndergraduateStudent
        Student undergraduateStudent = studentFactory.createStudent();
        undergraduateStudent.display();

        // Вызов метода createStudent() для создания объекта GraduateStudent
        Student graduateStudent = studentFactory.createStudent();
        graduateStudent.display();
    }
}
