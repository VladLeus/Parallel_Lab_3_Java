import java.util.LinkedList;

public interface Storage {

    public LinkedList<Integer> getStorage();
    void add(Integer elem) throws InterruptedException;

    Integer poll() throws InterruptedException;
}
