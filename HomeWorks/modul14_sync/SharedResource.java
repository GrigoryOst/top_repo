package HomeWorks.modul14_sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Создание класса SharedResource, который представляет общий ресурс
public class SharedResource {
    private int counter; // Переменная-счетчик
    private Lock lock; // Объект синхронизатора

    public SharedResource() {
        counter = 0;  // Инициализация счетчика значением 0
        lock = new ReentrantLock();  // Инициализация объекта синхронизатора
    }

    // Метод для увеличения счетчика
    public void increment() {
        lock.lock();  // Блокировка доступа к общему ресурсу
        try {
            counter++;  // Увеличение счетчика
        } finally {
            lock.unlock();  // Разблокировка доступа к общему ресурсу
        }
    }

    // Метод для уменьшения счетчика
    public void decrement() {
        lock.lock();  // Блокировка доступа к общему ресурсу
        try {
            counter--;  // Уменьшение счетчика
        } finally {
            lock.unlock();  // Разблокировка доступа к общему ресурсу
        }
    }

    // Метод для получения текущего значения счетчика
    public int getCounter() {
        return counter;
    }
}
