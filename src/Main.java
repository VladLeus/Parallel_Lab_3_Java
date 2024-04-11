
public class Main {
    public static void main(String[] args) {
        final int capacity = 10;
        Storage storage = new StorageSemaphore(capacity);


        for (int i = 0; i < 5; i++) {
            new Producer(i, storage).start();
            new Consumer(i, storage).start();
        }
    }
}