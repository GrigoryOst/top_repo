package HomeWorks.Modul13_multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger count; // Поле для хранения значения счетчика

    public Counter() {
        count = new AtomicInteger(0);  // Инициализация счетчика значением 0
    }

    // Метод, который увеличивает значение счетчика на 1
    public void increment() {
        count.incrementAndGet();
    }

    // Метод, который уменьшает значение счетчика на 1
    public void decrement() {
        count.decrementAndGet();
    }

    // Метод, который возвращает текущее значение счетчика
    public int getValue() {
        return count.get();
    }
}
