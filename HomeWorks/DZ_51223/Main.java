package HomeWorks.DZ_51223;

public class Main {
    public static void main(String[] args) {
        ComplexNumber number1 = new ComplexNumber(2.0, 3.0);
        ComplexNumber number2 = new ComplexNumber(1.0, 2.0);

        // Сравнение чисел
        System.out.println(number1.equals(number2)); // false

        // Сложение чисел
        ComplexNumber sum = number1.add(number2);
        System.out.println(sum.getRealPart()); // 3.0
        System.out.println(sum.getImaginaryPart()); // 5.0

        // Вычитание чисел
        ComplexNumber difference = number1.subtract(number2);
        System.out.println(sum.getRealPart()); // 1.0
        System.out.println(sum.getImaginaryPart()); // 1.0

        // Умножение чисел
        ComplexNumber product = number1.multiply(number2);
        System.out.println(product.getRealPart()); // -4.0
        System.out.println(product.getImaginaryPart()); // 7.0
    }
}
