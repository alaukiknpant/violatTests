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
import xxxx.foo.QueueSynchronizedWrongTest66;
import org.openjdk.jcstress.infra.results.StringResult0_jcstress;

public class QueueSynchronizedWrongTest66_jcstress extends Runner<StringResult0_jcstress> {

    OpenAddressHashCounter<StringResult0_jcstress> counter_actor0;
    OpenAddressHashCounter<StringResult0_jcstress> counter_actor1;
    volatile StateHolder<Pair> version;

    public QueueSynchronizedWrongTest66_jcstress(TestConfig config, TestResultCollector collector, ExecutorService pool) {
        super(config, collector, pool, "xxxx.foo.QueueSynchronizedWrongTest66");
    }

    @Override
    public void sanityCheck() throws Throwable {
        sanityCheck_API();
        sanityCheck_Footprints();
    }

    private void sanityCheck_API() throws Throwable {
        final QueueSynchronizedWrongTest66 t = new QueueSynchronizedWrongTest66();
        final QueueSynchronizedWrongTest66 s = new QueueSynchronizedWrongTest66();
        final StringResult0_jcstress r = new StringResult0_jcstress();
        Collection<Future<?>> res = new ArrayList<>();
        res.add(pool.submit(() -> t.actor0(r)));
        res.add(pool.submit(() -> t.actor1(r)));
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
            version = new StateHolder<>(new Pair[size], 2, config.spinLoopStyle);
            final QueueSynchronizedWrongTest66 t = new QueueSynchronizedWrongTest66();
            for (int c = 0; c < size; c++) {
                Pair p = new Pair();
                p.r = new StringResult0_jcstress();
                p.s = new QueueSynchronizedWrongTest66();
                version.pairs[c] = p;
                p.s.actor0(p.r);
                p.s.actor1(p.r);
            }
        });
    }

    @Override
    public Counter<StringResult0_jcstress> internalRun() {
        version = new StateHolder<>(new Pair[0], 2, config.spinLoopStyle);
        counter_actor0 = new OpenAddressHashCounter<>();
        counter_actor1 = new OpenAddressHashCounter<>();

        control.isStopped = false;
        Collection<Future<?>> tasks = new ArrayList<>();
        tasks.add(pool.submit(this::actor0));
        tasks.add(pool.submit(this::actor1));

        try {
            TimeUnit.MILLISECONDS.sleep(config.time);
        } catch (InterruptedException e) {
        }

        control.isStopped = true;

        waitFor(tasks);

        Counter<StringResult0_jcstress> counter = new OpenAddressHashCounter<>();
        counter.merge(counter_actor0);
        counter.merge(counter_actor1);
        return counter;
    }

    public final void jcstress_consume(StateHolder<Pair> holder, OpenAddressHashCounter<StringResult0_jcstress> cnt, int a, int actors) {
        Pair[] pairs = holder.pairs;
        int len = pairs.length;
        int left = a * len / actors;
        int right = (a + 1) * len / actors;
        for (int c = left; c < right; c++) {
            Pair p = pairs[c];
            StringResult0_jcstress r = p.r;
            QueueSynchronizedWrongTest66 s = p.s;
            p.s = new QueueSynchronizedWrongTest66();
            cnt.record(r);
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
                p.r = new StringResult0_jcstress();
                p.s = new QueueSynchronizedWrongTest66();
                newPairs[c] = p;
            }
         }

        version = new StateHolder<>(control.isStopped, newPairs, 2, config.spinLoopStyle);
        holder.finishUpdate();
   }

    public final Void actor0() {

        OpenAddressHashCounter<StringResult0_jcstress> counter = counter_actor0;
        while (true) {
            StateHolder<Pair> holder = version;
            if (holder.stopped) {
                return null;
            }

            Pair[] pairs = holder.pairs;

            holder.preRun();

            for (Pair p : pairs) {
                StringResult0_jcstress r = p.r;
                r.trap = 0;
                p.s.actor0(r);
            }

            holder.postRun();

            jcstress_consume(holder, counter, 0, 2);
            jcstress_updateHolder(holder);

            holder.postUpdate();
        }
    }

    public final Void actor1() {

        OpenAddressHashCounter<StringResult0_jcstress> counter = counter_actor1;
        while (true) {
            StateHolder<Pair> holder = version;
            if (holder.stopped) {
                return null;
            }

            Pair[] pairs = holder.pairs;

            holder.preRun();

            for (Pair p : pairs) {
                StringResult0_jcstress r = p.r;
                r.trap = 0;
                p.s.actor1(r);
            }

            holder.postRun();

            jcstress_consume(holder, counter, 1, 2);
            jcstress_updateHolder(holder);

            holder.postUpdate();
        }
    }

    static class Pair {
        public QueueSynchronizedWrongTest66 s;
        public StringResult0_jcstress r;
    }
}
