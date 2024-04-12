public class Consumer extends Thread {
    private final long id;
    private final Storage storage;


    public Consumer(long id, Storage storage, int itemsToConsume) {
        this.id = id;
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            while (!storage.getStorage().isEmpty()) {
                int element = storage.poll();
                Thread.sleep(1000);
                System.out.println("Consumer "+ id + " removed element: " + element);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
