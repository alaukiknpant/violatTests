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
public class CounterCorrect2HistoryTest7 {
    CounterCorrect2 obj = new CounterCorrect2();
    NoReorderCounter pc0 = new NoReorderCounter();
    NoReorderCounter pc1 = new NoReorderCounter();
    NoReorderCounter pc2 = new NoReorderCounter();
    NoReorderCounter pc3 = new NoReorderCounter();
    
    @Actor
    public void actor0(StringResult4 result) {
        String r;
        Object r0, r1;
        int pcs[][] = new int[4][3];
        int n = 0;
        
        try { pcs[n][0] = pc1.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc0.increment(); r = ResultAdapter.get(obj.incrementAndGet()); pcs[n][0] = pc1.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc0.increment(); }
        catch (Exception e) { pcs[n][0] = pc1.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc0.increment(); r = ResultAdapter.get(e); }
        r0 = r;
        
        try { pcs[n][0] = pc1.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc0.increment(); r = ResultAdapter.get(obj.incrementAndGet()); pcs[n][0] = pc1.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc0.increment(); }
        catch (Exception e) { pcs[n][0] = pc1.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc0.increment(); r = ResultAdapter.get(e); }
        r1 = r;
        
        result.r1 = "1@" + pcs[0][0] + ":" + "2@" + pcs[0][1] + ":" + "3@" + pcs[0][2] + "/" + "_" + ";" + "1@" + pcs[1][0] + ":" + "2@" + pcs[1][1] + ":" + "3@" + pcs[1][2] + "/" + r0 + ";" + "1@" + pcs[2][0] + ":" + "2@" + pcs[2][1] + ":" + "3@" + pcs[2][2] + "/" + "_" + ";" + "1@" + pcs[3][0] + ":" + "2@" + pcs[3][1] + ":" + "3@" + pcs[3][2] + "/" + r1;
    }
    
    @Actor
    public void actor1(StringResult4 result) {
        String r;
        Object r0, r1, r2;
        int pcs[][] = new int[6][3];
        int n = 0;
        
        try { pcs[n][0] = pc0.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc1.increment(); r = ResultAdapter.get(obj.incrementAndGet()); pcs[n][0] = pc0.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc1.increment(); }
        catch (Exception e) { pcs[n][0] = pc0.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc1.increment(); r = ResultAdapter.get(e); }
        r0 = r;
        
        try { pcs[n][0] = pc0.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc1.increment(); r = ResultAdapter.get(obj.incrementAndGet()); pcs[n][0] = pc0.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc1.increment(); }
        catch (Exception e) { pcs[n][0] = pc0.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc1.increment(); r = ResultAdapter.get(e); }
        r1 = r;
        
        try { pcs[n][0] = pc0.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc1.increment(); r = ResultAdapter.get(obj.incrementAndGet()); pcs[n][0] = pc0.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc1.increment(); }
        catch (Exception e) { pcs[n][0] = pc0.get(); pcs[n][1] = pc2.get(); pcs[n][2] = pc3.get(); n++; pc1.increment(); r = ResultAdapter.get(e); }
        r2 = r;
        
        result.r2 = "0@" + pcs[0][0] + ":" + "2@" + pcs[0][1] + ":" + "3@" + pcs[0][2] + "/" + "_" + ";" + "0@" + pcs[1][0] + ":" + "2@" + pcs[1][1] + ":" + "3@" + pcs[1][2] + "/" + r0 + ";" + "0@" + pcs[2][0] + ":" + "2@" + pcs[2][1] + ":" + "3@" + pcs[2][2] + "/" + "_" + ";" + "0@" + pcs[3][0] + ":" + "2@" + pcs[3][1] + ":" + "3@" + pcs[3][2] + "/" + r1 + ";" + "0@" + pcs[4][0] + ":" + "2@" + pcs[4][1] + ":" + "3@" + pcs[4][2] + "/" + "_" + ";" + "0@" + pcs[5][0] + ":" + "2@" + pcs[5][1] + ":" + "3@" + pcs[5][2] + "/" + r2;
    }
    
    @Actor
    public void actor2(StringResult4 result) {
        String r;
        Object r0, r1, r2;
        int pcs[][] = new int[6][3];
        int n = 0;
        
        try { pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); pcs[n][2] = pc3.get(); n++; pc2.increment(); r = ResultAdapter.get(obj.incrementAndGet()); pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); pcs[n][2] = pc3.get(); n++; pc2.increment(); }
        catch (Exception e) { pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); pcs[n][2] = pc3.get(); n++; pc2.increment(); r = ResultAdapter.get(e); }
        r0 = r;
        
        try { pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); pcs[n][2] = pc3.get(); n++; pc2.increment(); r = ResultAdapter.get(obj.incrementAndGet()); pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); pcs[n][2] = pc3.get(); n++; pc2.increment(); }
        catch (Exception e) { pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); pcs[n][2] = pc3.get(); n++; pc2.increment(); r = ResultAdapter.get(e); }
        r1 = r;
        
        try { pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); pcs[n][2] = pc3.get(); n++; pc2.increment(); r = ResultAdapter.get(obj.incrementAndGet()); pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); pcs[n][2] = pc3.get(); n++; pc2.increment(); }
        catch (Exception e) { pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); pcs[n][2] = pc3.get(); n++; pc2.increment(); r = ResultAdapter.get(e); }
        r2 = r;
        
        result.r3 = "0@" + pcs[0][0] + ":" + "1@" + pcs[0][1] + ":" + "3@" + pcs[0][2] + "/" + "_" + ";" + "0@" + pcs[1][0] + ":" + "1@" + pcs[1][1] + ":" + "3@" + pcs[1][2] + "/" + r0 + ";" + "0@" + pcs[2][0] + ":" + "1@" + pcs[2][1] + ":" + "3@" + pcs[2][2] + "/" + "_" + ";" + "0@" + pcs[3][0] + ":" + "1@" + pcs[3][1] + ":" + "3@" + pcs[3][2] + "/" + r1 + ";" + "0@" + pcs[4][0] + ":" + "1@" + pcs[4][1] + ":" + "3@" + pcs[4][2] + "/" + "_" + ";" + "0@" + pcs[5][0] + ":" + "1@" + pcs[5][1] + ":" + "3@" + pcs[5][2] + "/" + r2;
    }
    
    @Actor
    public void actor3(StringResult4 result) {
        String r;
        Object r0;
        int pcs[][] = new int[2][3];
        int n = 0;
        
        try { pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); pcs[n][2] = pc2.get(); n++; pc3.increment(); r = ResultAdapter.get(obj.incrementAndGet()); pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); pcs[n][2] = pc2.get(); n++; pc3.increment(); }
        catch (Exception e) { pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); pcs[n][2] = pc2.get(); n++; pc3.increment(); r = ResultAdapter.get(e); }
        r0 = r;
        
        result.r4 = "0@" + pcs[0][0] + ":" + "1@" + pcs[0][1] + ":" + "2@" + pcs[0][2] + "/" + "_" + ";" + "0@" + pcs[1][0] + ":" + "1@" + pcs[1][1] + ":" + "2@" + pcs[1][2] + "/" + r0;
    }
}
