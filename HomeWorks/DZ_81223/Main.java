package HomeWorks.DZ_81223;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //twoNumbers();
        //reverse();
        //simpleNumbers();
        factorial();
    }

    /*Пользователь вводит с клавиатуры два числа. Необходимо найти сумму чисел, разницу чисел,
    произведение чисел. Результат ввычеслений вывести на экран.*/
    public static void twoNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        int num1 = scanner.nextInt(); // пользователь вводит первое число

        System.out.println("Введите второе число:");
        int num2 = scanner.nextInt(); // пользователь вводит второе число

        int sum = num1 + num2; // вычисляем сумму двух чисел
        int diff = num1 - num2; // вычисляем разницу двух чисел
        int product = num1 * num2; // вычисляем произведение двух чисел

        System.out.println("Сумма чисел: " + sum); // выводим сумму
        System.out.println("Разница чисел: " + diff); // выводим разницу
        System.out.println("Произведение чисел: " + product); // выводим произведение
    }

    /*Пользователь с клавиатуры вводит четырехзначное число.
    Необходимо перевернуть число и отобразить результат.
    Например, если введено 4512, результат 2154.*/
    public static void reverse() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите четырехзначное число:");
        int number = scanner.nextInt(); // пользователь вводит четырехзначное число

        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10; // получаем последнюю цифру числа
            reversedNumber = reversedNumber * 10 + digit; // записываем цифру в обратном порядке
            number /= 10; // сокращаем число на одну цифру
        }

        System.out.println("Результат: " + reversedNumber); // выводим результат
    }

    /*Показать на экран все простые числа в диапазоне, указанном пользователем.
    Число называется простым, если оно делится без остатка только на себя и единицу.
    Например, три - это простое число, а четыре нет.*/
    public static void simpleNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начало диапазона:");
        int start = scanner.nextInt(); // пользователь вводит начало диапазона

        System.out.println("Введите конец диапазона:");
        int end = scanner.nextInt(); // пользователь вводит конец диапазона

        for (int i = start; i <= end; i++) { // проходим по всем числам в диапазоне
            if (isPrime(i)) { // проверяем, является ли число простым
                System.out.println(i); // выводим простое число
            }
        }
    }
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*Напишите метод, высчитывающий факториал каждого элемента массива.
    Метод возвращает новый массив, содержащий полученные факториалы.*/
    public static void factorial() {
        int[] array = {1, 2, 3, 4, 5}; // задаем массив

        int[] factorialArray = calculateFactorial(array); // вычисляем факториалы для каждого элемента массива

        for (int i = 0; i < factorialArray.length; i++) {
            System.out.println("Факториал элемента " + i + ": " + factorialArray[i]); // выводим факториалы
        }
    }
    public static int[] calculateFactorial(int[] array) {
        int[] factorialArray = new int[array.length]; // создаем новый массив для факториалов

        for (int i = 0; i < array.length; i++) {
            factorialArray[i] = factorial(array[i]); // вычисляем факториал каждого элемента массива
        }

        return factorialArray;
    }

    public static int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i; // вычисляем факториал
        }
        return result;
    }
}
