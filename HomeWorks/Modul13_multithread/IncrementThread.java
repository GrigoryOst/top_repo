package HomeWorks.Modul13_multithread;

// Создание класса IncrementThread, который представляет поток инкремента
public class IncrementThread extends Thread {
    private Counter counter; // Экземпляр класса Counter
    private int iterations; // Количество итераций инкремента

    public IncrementThread(Counter counter, int iterations) {
        this.counter = counter;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        // Цикл, в котором вызывается метод increment объекта Counter заданное количество раз
        for (int i = 0; i < iterations; i++) {
            counter.increment();
        }
    }
}
