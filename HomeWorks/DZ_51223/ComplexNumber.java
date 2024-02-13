package HomeWorks.DZ_51223;

public class ComplexNumber {
    // Задаем вещественную и мнимую части комплексного числа
    private double realPart;
    private double imaginaryPart;

    // Конструкторы класса
    public ComplexNumber() {
        this.realPart = 0.0;
        this.imaginaryPart = 0.0;
    }

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    // Геттеры и сеттеры для получения и изменения вещественной и мнимой частей числа
    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    // Метод для сравнения двух комплексных чисел
    public boolean equals(ComplexNumber other) {
        return this.realPart == other.realPart && this.imaginaryPart == other.imaginaryPart;
    }

    // Метод для сложения двух комплексных чисел
    public ComplexNumber add(ComplexNumber other) {
        double realResult = this.realPart + other.realPart;
        double imaginaryResult = this.imaginaryPart + other.imaginaryPart;
        return new ComplexNumber(realResult, imaginaryResult);
    }

    // Метод для вычитания двух комплексных чисел
    public ComplexNumber subtract(ComplexNumber other) {
        double realResult = this.realPart - other.realPart;
        double imaginaryResult = this.imaginaryPart - other.imaginaryPart;
        return new ComplexNumber(realResult, imaginaryResult);
    }

    // Метод для умножения двух комплексных чисел
    public ComplexNumber multiply(ComplexNumber other) {
        double realResult = this.realPart * other.realPart - this.imaginaryPart * other.imaginaryPart;
        double imaginaryResult = this.realPart * other.imaginaryPart + this.imaginaryPart * other.realPart;
        return new ComplexNumber(realResult, imaginaryResult);
    }
}
