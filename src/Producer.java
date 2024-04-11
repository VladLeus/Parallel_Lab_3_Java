import java.util.Random;

public class Producer extends Thread {
    private final long id;
    private final Storage storage;


    public Producer(long id, Storage storage) {
        this.id = id;
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            Integer element = new Random().nextInt(0, 11);
            storage.add(element);
            System.out.println("Producer "+ id + " added element: " + element);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
