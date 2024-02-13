package HomeWorks.modul14_sync;

/* 1. Создайте класс, который будет представлять общий ресурс.
Этот класс должен содержать переменную-счетчик и методы для его увеличения и уменьшения.

2. В классе с общим ресурсом создайте объект синхронизатора, например, объект класса "Semaphore" или "Lock".
Этот объект будет использоваться для синхронизации доступа к общему ресурсу.

3. Создайте несколько потоков, которые будут одновременно использовать общий ресурс.
Каждый поток должен вызывать методы увеличения и уменьшения счетчика.

4. Внутри методов увеличения и уменьшения счетчика используйте методы синхронизатора для блокировки и разблокировки доступа к общему ресурсу.*/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();  // Создание общего ресурса

        // Создание и запуск потоков, которые используют общий ресурс
        WorkerThread workerThread1 = new WorkerThread(sharedResource);
        WorkerThread workerThread2 = new WorkerThread(sharedResource);
        workerThread1.start();
        workerThread2.start();

        // Ожидание завершения всех потоков
        workerThread1.join();
        workerThread2.join();

        // Вывод текущего значения счетчика
        System.out.println(sharedResource.getCounter());
    }
}
