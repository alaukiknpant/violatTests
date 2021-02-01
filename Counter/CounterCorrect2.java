
import java.util.concurrent.atomic.AtomicInteger;


public class CounterCorrect2 {
    private AtomicInteger c;

    public CounterCorrect2() {
        c = new AtomicInteger();
    }


    public synchronized int incrementAndGet() {
        return c.incrementAndGet();
    }
}
