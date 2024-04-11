
public interface Storage {

    void add(Integer elem) throws InterruptedException;

    Integer poll() throws InterruptedException;
}
