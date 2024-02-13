package HomeWorks.modul14_sync;
// Создание класса WorkerThread, который представляет поток, использующий общий ресурс
public class WorkerThread extends Thread {
    private SharedResource sharedResource;  // Общий ресурс

    public WorkerThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;  // Инициализация общего ресурса
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            sharedResource.increment();  // Увеличение счетчика
            sharedResource.decrement();  // Уменьшение счетчика
        }
    }
}
