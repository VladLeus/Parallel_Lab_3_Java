import java.util.LinkedList;
public class StorageWait implements Storage {
    private final int capacity;
    private final LinkedList<Integer> storage;


    public StorageWait(int capacity) {
        this.capacity = capacity;
        this.storage = new LinkedList<>();
    }

    public synchronized void add(Integer elem) throws InterruptedException {
        while (storage.size() == capacity) {
            System.out.println("Storage is full");
            wait();
        }

        storage.add(elem);
        notifyAll();
    }

    public synchronized Integer poll() throws InterruptedException {
        while (storage.isEmpty()) {
            System.out.println("Storage is empty");
            wait();
        }

        Integer element = storage.poll();
        notifyAll();
        return element;
    }
}
