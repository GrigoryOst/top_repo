package HomeWorks.modul_8_isklucenia;

/*Задание 3
        Создать класс, объекты которого будут неизменяемыми.
        Класс инкапсулирует в себе информацию о треугольнике на плоскости (длины каждой из его ребер).
        Длины сторон задаются в конструкторе. Если по заданным сторонам нельзя
        построить треугольник, в конструктор должно бросаться исключение.*/

public class Triangle {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("Треугольник с такими сторонами не существует");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    // Геттеры для сторон треугольника
    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }
}
