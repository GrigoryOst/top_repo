package HomeWorks.DZ_291123;

/**
 * Класс MyArrayList представляет собой контейнер, реализующий логику работы одномерного безразмерного динамического массива.
 */
public class MyArrayList<T> {

    private T[] data; // ссылка на инкапсулированный массив
    private int size; // текущее количество существующих элементов в массиве
    private int capacity; // текущая емкость массива

    /**
     * Конструктор с параметром, задающий начальную емкость массива.
     *
     * @param initialCapacity начальная емкость массива
     */
    public MyArrayList(int initialCapacity) {
        data = (T[]) new Object[initialCapacity];
        size = 0;
        capacity = initialCapacity;
    }

    /**
     * Конструктор по умолчанию.
     * Создает массив на 10 элементов, равных нулю.
     * Использует конструктор с параметром для уменьшения кода.
     */
    public MyArrayList() {
        this(10);
    }

    /**
     * Метод для получения текущего количества существующих элементов в массиве.
     *
     * @return текущее количество существующих элементов
     */
    public int getSize() {
        return size;
    }

    /**
     * Переопределение метода toString.
     * Возвращает строковое представление элементов массива через пробел.
     *
     * @return строковое представление элементов массива
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]).append(" ");
        }
        return stringBuilder.toString();
    }

    /**
     * Закрытый метод, проверяющий достаточность памяти в массиве для указанного количества элементов.
     * Если значение параметра меньше текущей емкости массива, ничего не происходит.
     * Если значение параметра больше текущей емкости массива, массив пересоздается с новой емкостью.
     * Существующие элементы переносятся в новый массив и не теряются.
     *
     * @param requiredCapacity проверяемая емкость массива
     */
    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > capacity) {
            int newCapacity = (int) (capacity * 1.5) + 1; // увеличиваем емкость в 1.5 раза и добавляем 1 элемент
            T[] newData = (T[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
            capacity = newCapacity;
        }
    }
}