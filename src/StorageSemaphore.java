import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class StorageSemaphore  implements Storage {
    private final LinkedList<Integer> storage = new LinkedList<>();
    private final Semaphore spaceAvailable;
    private final Semaphore itemsAvailable;

    public StorageSemaphore(int capacity) {
        this.spaceAvailable = new Semaphore(capacity);
        this.itemsAvailable = new Semaphore(0);
    }

    @Override
    public LinkedList<Integer> getStorage() {
        return storage;
    }

    public void add(Integer elem) throws InterruptedException {
        spaceAvailable.acquire();
        synchronized (this) {
            storage.add(elem);
        }
        itemsAvailable.release();
    }

    public Integer poll() throws InterruptedException {
        itemsAvailable.acquire();
        Integer element;
        synchronized (this) {
            element = storage.poll();
        }
        spaceAvailable.release();
        return element;
    }
}
