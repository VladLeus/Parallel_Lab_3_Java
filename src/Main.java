
public class Main {
    public static void main(String[] args) {
        final int capacity = 7;
        final int items = 10;
        Storage storage = new StorageWait(capacity);
        /*Storage storage = new StorageSemaphore(capacity);*/


        for (int i = 0; i < 5; i++) {
            new Producer(i, storage, items).start();
        }

        for (int i = 0; i < 3; i++) {
            new Consumer(i, storage, items).start();
        }
    }
}