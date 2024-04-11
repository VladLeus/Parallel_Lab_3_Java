public class Consumer extends Thread {
    private final long id;
    private final Storage storage;


    public Consumer(long id, Storage storage) {
        this.id = id;
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            int element = storage.poll();
            System.out.println("Consumer "+ id + " removed element: " + element);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
