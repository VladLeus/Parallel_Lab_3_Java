
public class Main {
    public static void main(String[] args) {
        final int capacity = 7;
        final int items = 10;
        final int producersAmount = 5;
        final int consumersAmount = 3;
        Storage storage = new StorageWait(capacity);
        /*Storage storage = new StorageSemaphore(capacity);*/


        for (int i = 0; i < producersAmount; i++) {
            new Producer(i, storage, items).start();
        }

        for (int i = 0; i < consumersAmount; i++) {
            new Consumer(i, storage, (items * producersAmount) / consumersAmount).start();
        }
    }
}