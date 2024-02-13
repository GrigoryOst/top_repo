package HomeWorks.modul_8_isklucenia;

/*
Задание 1
 Создать метод, который выводит в консоль результат целочисленного деления числа,
 введенного с клавиатуры, на значения элементов одномерного массива целых чисел,
 заполненный случайным образом – от -10 до 10. Длина массива случайная – от 1 до 10.
 Обработать все возможные исключительные ситуации в данном методе.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            divideByRandomArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void divideByRandomArray() throws Exception {
        Random random = new Random();
        int arrayLength = random.nextInt(10) + 1; // Длина массива от 1 до 10
        int[] array = new int[arrayLength];

        // Заполняем массив случайными числами от -10 до 10
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(21) - 10;
        }
        System.out.println(Arrays.toString(array));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = scanner.nextInt();

        for (int i : array) {
            if (i == 0) {
                throw new ArithmeticException("Деление на ноль");
            }
            System.out.println(number / i);
        }
    }
}