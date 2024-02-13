package HomeWorks.Modul17_Patterns;

import HomeWorks.Modul17_Patterns.Factory.StudentFactory;

public class Main {
    public static void main(String[] args) {
        Singlton1();
        Builder1();
    }

    /* Создайте класс Singleton, реализующий паттерн Singleton. У этого класса должен быть приватный статический экземпляр класса Student,
    приватный конструктор и статический метод getInstance(), который возвращает этот экземпляр класса.
    Проверьте работу класса, создав несколько объектов Student и убедившись, что они ссылаются на один и тот же экземпляр. */
    public static void Singlton1 () {
        Singleton student1 = Singleton.getInstance(); // Создание объекта student1
        Singleton student2 = Singleton.getInstance(); // Получение уже созданного объекта

        System.out.println(student1);  // Вывод объекта student1
        System.out.println(student2);  // Вывод объекта student2
        System.out.println(student1 == student2);  // Проверка, ссылаются ли объекты на один и тот же экземпляр
    }

    /* Создайте класс Builder, реализующий паттерн Builder. У этого класса должны быть поля для всех необходимых параметров объекта Student,
    методы для установки значений этих параметров (setFirstName(), setLastName() и т.д.) и метод build(),
    который возвращает готовый объект Student. Создайте объект с помощью паттерна Builder,
    используя все доступные методы для установки значений параметров. */
    public static void Builder1 () {
        StudentB studentB = new StudentB.Builder()
                .setFirstName("Name") // Установка имени студента
                .setLastName("Last") // Установка фамилии студента
                .setAge(22) // Установка возраста студента
                .build(); // Создание объекта Student с помощью паттерна Builder

        System.out.println("First Name: " + studentB.getFirstName());  // Вывод имени студента
        System.out.println("Last Name: " + studentB.getLastName());  // Вывод фамилии студента
        System.out.println("Age: " + studentB.getAge());  // Вывод возраста студента
    }



}
