package HomeWorks.DZ_121123;

import java.util.Scanner;

public class RangeLength {

    public void rangeLength1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество диапазонов:");
        int n = scanner.nextInt();
        int[] lengths = new int[n];
        int[][] ranges = new int[n][2];

        System.out.println("Введите диапазоны в формате начало_диапазона конец_диапазона:");
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            if (start > end) {
                System.out.println("Ошибка: начало диапазона больше, чем конец");
                return;
            }
            lengths[i] = end - start;
            ranges[i][0] = start;
            ranges[i][1] = end;
        }

        System.out.println("Длины диапазонов:");
        for (int length : lengths) {
            System.out.println(length);
        }

        System.out.println("Проверка пересечения диапазонов:");
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ranges[i][0] <= ranges[j][1]
                        &&
                    ranges[j][0] <= ranges[i][1]) {
                    System.out.println("Диапазон " + (i+1) + " пересекается с диапазоном " + (j+1));
                }
            }
        }
    }
}
