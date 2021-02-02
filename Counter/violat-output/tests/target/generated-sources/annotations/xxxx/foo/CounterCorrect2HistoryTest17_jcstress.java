package xxxx.foo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.openjdk.jcstress.infra.runners.TestConfig;
import org.openjdk.jcstress.infra.collectors.TestResultCollector;
import org.openjdk.jcstress.infra.runners.Runner;
import org.openjdk.jcstress.infra.runners.StateHolder;
import org.openjdk.jcstress.util.Counter;
import org.openjdk.jcstress.vm.WhiteBoxSupport;
import org.openjdk.jcstress.util.OpenAddressHashCounter;
import java.util.concurrent.ExecutionException;
import xxxx.foo.CounterCorrect2HistoryTest17;
import org.openjdk.jcstress.infra.results.StringResult3_jcstress;

public class CounterCorrect2HistoryTest17_jcstress extends Runner<StringResult3_jcstress> {

    OpenAddressHashCounter<StringResult3_jcstress> counter_actor0;
    OpenAddressHashCounter<StringResult3_jcstress> counter_actor1;
    OpenAddressHashCounter<StringResult3_jcstress> counter_actor2;
    volatile StateHolder<Pair> version;

    public CounterCorrect2HistoryTest17_jcstress(TestConfig config, TestResultCollector collector, ExecutorService pool) {
        super(config, collector, pool, "xxxx.foo.CounterCorrect2HistoryTest17");
    }

    @Override
    public void sanityCheck() throws Throwable {
        sanityCheck_API();
        sanityCheck_Footprints();
    }

    private void sanityCheck_API() throws Throwable {
        final CounterCorrect2HistoryTest17 t = new CounterCorrect2HistoryTest17();
        final CounterCorrect2HistoryTest17 s = new CounterCorrect2HistoryTest17();
        final StringResult3_jcstress r = new StringResult3_jcstress();
        Collection<Future<?>> res = new ArrayList<>();
        res.add(pool.submit(() -> t.actor0(r)));
        res.add(pool.submit(() -> t.actor1(r)));
        res.add(pool.submit(() -> t.actor2(r)));
        for (Future<?> f : res) {
            try {
                f.get();
            } catch (ExecutionException e) {
                throw e.getCause();
            }
        }
    }

    private void sanityCheck_Footprints() throws Throwable {
        config.adjustStrides(size -> {
            version = new StateHolder<>(new Pair[size], 3, config.spinLoopStyle);
            final CounterCorrect2HistoryTest17 t = new CounterCorrect2HistoryTest17();
            for (int c = 0; c < size; c++) {
                Pair p = new Pair();
                p.r = new StringResult3_jcstress();
                p.s = new CounterCorrect2HistoryTest17();
                version.pairs[c] = p;
                p.s.actor0(p.r);
                p.s.actor1(p.r);
                p.s.actor2(p.r);
            }
        });
    }

    @Override
    public Counter<StringResult3_jcstress> internalRun() {
        version = new StateHolder<>(new Pair[0], 3, config.spinLoopStyle);
        counter_actor0 = new OpenAddressHashCounter<>();
        counter_actor1 = new OpenAddressHashCounter<>();
        counter_actor2 = new OpenAddressHashCounter<>();

        control.isStopped = false;
        Collection<Future<?>> tasks = new ArrayList<>();
        tasks.add(pool.submit(this::actor0));
        tasks.add(pool.submit(this::actor1));
        tasks.add(pool.submit(this::actor2));

        try {
            TimeUnit.MILLISECONDS.sleep(config.time);
        } catch (InterruptedException e) {
        }

        control.isStopped = true;

        waitFor(tasks);

        Counter<StringResult3_jcstress> counter = new OpenAddressHashCounter<>();
        counter.merge(counter_actor0);
        counter.merge(counter_actor1);
        counter.merge(counter_actor2);
        return counter;
    }

    public final void jcstress_consume(StateHolder<Pair> holder, OpenAddressHashCounter<StringResult3_jcstress> cnt, int a, int actors) {
        Pair[] pairs = holder.pairs;
        int len = pairs.length;
        int left = a * len / actors;
        int right = (a + 1) * len / actors;
        for (int c = left; c < right; c++) {
            Pair p = pairs[c];
            StringResult3_jcstress r = p.r;
            CounterCorrect2HistoryTest17 s = p.s;
            p.s = new CounterCorrect2HistoryTest17();
            cnt.record(r);
            r.r1 = null;
            r.r2 = null;
            r.r3 = null;
        }
    }

    public final void jcstress_updateHolder(StateHolder<Pair> holder) {
        if (!holder.tryStartUpdate()) return;
        Pair[] pairs = holder.pairs;
        int len = pairs.length;

        int newLen = holder.updateStride ? Math.max(config.minStride, Math.min(len * 2, config.maxStride)) : len;

        Pair[] newPairs = pairs;
        if (newLen > len) {
            newPairs = Arrays.copyOf(pairs, newLen);
            for (int c = len; c < newLen; c++) {
                Pair p = new Pair();
                p.r = new StringResult3_jcstress();
                p.s = new CounterCorrect2HistoryTest17();
                newPairs[c] = p;
            }
         }

        version = new StateHolder<>(control.isStopped, newPairs, 3, config.spinLoopStyle);
        holder.finishUpdate();
   }

    public final Void actor0() {

        OpenAddressHashCounter<StringResult3_jcstress> counter = counter_actor0;
        while (true) {
            StateHolder<Pair> holder = version;
            if (holder.stopped) {
                return null;
            }

            Pair[] pairs = holder.pairs;

            holder.preRun();

            for (Pair p : pairs) {
                StringResult3_jcstress r = p.r;
                r.trap = 0;
                p.s.actor0(r);
            }

            holder.postRun();

            jcstress_consume(holder, counter, 0, 3);
            jcstress_updateHolder(holder);

            holder.postUpdate();
        }
    }

    public final Void actor1() {

        OpenAddressHashCounter<StringResult3_jcstress> counter = counter_actor1;
        while (true) {
            StateHolder<Pair> holder = version;
            if (holder.stopped) {
                return null;
            }

            Pair[] pairs = holder.pairs;

            holder.preRun();

            for (Pair p : pairs) {
                StringResult3_jcstress r = p.r;
                r.trap = 0;
                p.s.actor1(r);
            }

            holder.postRun();

            jcstress_consume(holder, counter, 1, 3);
            jcstress_updateHolder(holder);

            holder.postUpdate();
        }
    }

    public final Void actor2() {

        OpenAddressHashCounter<StringResult3_jcstress> counter = counter_actor2;
        while (true) {
            StateHolder<Pair> holder = version;
            if (holder.stopped) {
                return null;
            }

            Pair[] pairs = holder.pairs;

            holder.preRun();

            for (Pair p : pairs) {
                StringResult3_jcstress r = p.r;
                r.trap = 0;
                p.s.actor2(r);
            }

            holder.postRun();

            jcstress_consume(holder, counter, 2, 3);
            jcstress_updateHolder(holder);

            holder.postUpdate();
        }
    }

    static class Pair {
        public CounterCorrect2HistoryTest17 s;
        public StringResult3_jcstress r;
    }
}
