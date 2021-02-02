package xxxx.foo;

import java.util.Arrays;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.foo.CounterCorrect2;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.*;

@JCStressTest
@Outcome(id = ".*", expect = Expect.ACCEPTABLE, desc = "")
@State
public class CounterCorrect2HistoryTest5 {
    CounterCorrect2 obj = new CounterCorrect2();
    NoReorderCounter pc0 = new NoReorderCounter();
    NoReorderCounter pc1 = new NoReorderCounter();
    
    @Actor
    public void actor0(StringResult2 result) {
        String r;
        Object r0, r1;
        int pcs[][] = new int[4][1];
        int n = 0;
        
        try { pcs[n][0] = pc1.get(); n++; pc0.increment(); r = ResultAdapter.get(obj.incrementAndGet()); pcs[n][0] = pc1.get(); n++; pc0.increment(); }
        catch (Exception e) { pcs[n][0] = pc1.get(); n++; pc0.increment(); r = ResultAdapter.get(e); }
        r0 = r;
        
        try { pcs[n][0] = pc1.get(); n++; pc0.increment(); r = ResultAdapter.get(obj.incrementAndGet()); pcs[n][0] = pc1.get(); n++; pc0.increment(); }
        catch (Exception e) { pcs[n][0] = pc1.get(); n++; pc0.increment(); r = ResultAdapter.get(e); }
        r1 = r;
        
        result.r1 = "1@" + pcs[0][0] + "/" + "_" + ";" + "1@" + pcs[1][0] + "/" + r0 + ";" + "1@" + pcs[2][0] + "/" + "_" + ";" + "1@" + pcs[3][0] + "/" + r1;
    }
    
    @Actor
    public void actor1(StringResult2 result) {
        String r;
        Object r0, r1;
        int pcs[][] = new int[4][1];
        int n = 0;
        
        try { pcs[n][0] = pc0.get(); n++; pc1.increment(); r = ResultAdapter.get(obj.incrementAndGet()); pcs[n][0] = pc0.get(); n++; pc1.increment(); }
        catch (Exception e) { pcs[n][0] = pc0.get(); n++; pc1.increment(); r = ResultAdapter.get(e); }
        r0 = r;
        
        try { pcs[n][0] = pc0.get(); n++; pc1.increment(); r = ResultAdapter.get(obj.incrementAndGet()); pcs[n][0] = pc0.get(); n++; pc1.increment(); }
        catch (Exception e) { pcs[n][0] = pc0.get(); n++; pc1.increment(); r = ResultAdapter.get(e); }
        r1 = r;
        
        result.r2 = "0@" + pcs[0][0] + "/" + "_" + ";" + "0@" + pcs[1][0] + "/" + r0 + ";" + "0@" + pcs[2][0] + "/" + "_" + ";" + "0@" + pcs[3][0] + "/" + r1;
    }
}
