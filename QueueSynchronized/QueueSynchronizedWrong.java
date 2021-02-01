import java.util.Arrays;


public class QueueSynchronizedWrong  {
    private int indGet;
    private int indPut;
    private int countElements;
    private int[] items;
    private int inc(int i) {
        return (++i == items.length ? 0 : i);
    }

    public QueueSynchronizedWrong() {
        items = new int[1000];
        indPut = 0;
        indGet = 0;
        countElements = 0;

    }

    public void put(Integer i) throws Exception  {
        if (countElements == items.length) {
            throw new Exception("Queue is full");
        } else {
            items[indPut] = i;
            indPut = inc(indPut);
            countElements++;
        }

    }

    public int get() throws Exception{
        if (countElements == 0) {
            throw new Exception("Queue is empty");
        } else {
            int ret = items[indGet];
            indGet = inc(indGet);
            countElements--;
            return ret;
        }

    }

    public String toString() {
        return "QueueWithoutAnySync{" +
                "indGet=" + indGet +
                ", indPut=" + indPut +
                ", countElements=" + countElements +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}

