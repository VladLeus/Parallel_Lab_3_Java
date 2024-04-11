import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class StorageSemaphore  implements Storage {
    private final int capacity;
    private final LinkedList<Integer> storage;
    private final Semaphore semaphore;

    public StorageSemaphore(int capacity) {
        this.capacity = capacity;
        this.storage = new LinkedList<>();
        this.semaphore = new Semaphore(capacity);
    }

    public void add(Integer elem) throws InterruptedException {
        semaphore.acquire();  // Acquire a permit
        synchronized (this) {
            storage.add(elem);
            System.out.println("Producer added element: " + elem);
            notifyAll();
        }
    }

    public Integer poll() throws InterruptedException {
        Integer element;
        synchronized (this) {
            while (storage.isEmpty()) {
                wait();
            }
            element = storage.poll();
            System.out.println("Consumer removed element: " + element);
            notifyAll();
        }
        semaphore.release();  // Release a permit
        return element;
    }
}
