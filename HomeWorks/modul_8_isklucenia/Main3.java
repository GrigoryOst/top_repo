package HomeWorks.modul_8_isklucenia;

/*Задание 4
        Напишите метод бинарного поиска в одномерном массиве.
        В случае, если массив не отсортирован,
        метод должен бросать проверяемое исключение.*/

public class Main3 {
    public static void main(String[] args) {
        try {
            int[] array = {1, 2, 3, 4, 5};
            System.out.println(binarySearch(array, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int binarySearch(int[] array, int key) throws Exception {
        if (!isSorted(array)) {
            throw new Exception("Массив не отсортирован");
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1; // ключ не найден
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
