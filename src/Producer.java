import java.util.Random;

public class Producer extends Thread {
    private final long id;
    private final Storage storage;

    private final int itemsToProduce;


    public Producer(long id, Storage storage, int itemsToProduce) {
        this.id = id;
        this.storage = storage;
        this.itemsToProduce = itemsToProduce;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemsToProduce; i++) {
                Integer element = new Random().nextInt(0, 11);
                storage.add(element);
                Thread.sleep(1000);
                System.out.println("Producer "+ id + " added element: " + element);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
