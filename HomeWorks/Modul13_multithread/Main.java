package HomeWorks.Modul13_multithread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();  // Создание экземпляра класса Counter

        // Создание объектов класса IncrementThread и DecrementThread с различными значениями количества итераций
        IncrementThread incrementThread = new IncrementThread(counter, 53);
        DecrementThread decrementThread = new DecrementThread(counter, 12);

        // Запуск всех потоков
        incrementThread.start();
        decrementThread.start();

        // Дождитесь завершения всех потоков
        incrementThread.join();
        decrementThread.join();

        // Вывод значения счетчика на экран
        System.out.println(counter.getValue());
    }
}
