package HomeWorks.Modul13_multithread;

public class DecrementThread extends Thread {
    private Counter counter;  // Экземпляр класса Counter
    private int iterations;  // Количество итераций декремента

    public DecrementThread(Counter counter, int iterations) {
        this.counter = counter;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        // Цикл, в котором вызывается метод decrement объекта Counter заданное количество раз
        for (int i = 0; i < iterations; i++) {
            counter.decrement();
        }
    }
}
