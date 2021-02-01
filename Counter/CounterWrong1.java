public class CounterWrong1 {
    private int c;

    public CounterWrong1() {
        c = 0;
    }

    
    public int incrementAndGet() {
        c++;
        return c;
    }
}
