package xxxx.foo;

import java.util.Arrays;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.foo.QueueSynchronized;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.*;

@JCStressTest
@Outcome(id = ".*", expect = Expect.ACCEPTABLE, desc = "")
@State
public class QueueSynchronizedHistoryTest6 {
    QueueSynchronized obj = new QueueSynchronized();
    NoReorderCounter pc0 = new NoReorderCounter();
    NoReorderCounter pc1 = new NoReorderCounter();
    NoReorderCounter pc2 = new NoReorderCounter();
    
    @Actor
    public void actor0(StringResult3 result) {
        String r;
        Object r0, r1;
        int pcs[][] = new int[4][2];
        int n = 0;
        
        try { pcs[n][0] = pc1.get(); pcs[n][1] = pc2.get(); n++; pc0.increment(); r = ResultAdapter.get(obj.get()); pcs[n][0] = pc1.get(); pcs[n][1] = pc2.get(); n++; pc0.increment(); }
        catch (Exception e) { pcs[n][0] = pc1.get(); pcs[n][1] = pc2.get(); n++; pc0.increment(); r = ResultAdapter.get(e); }
        r0 = r;
        
        try { pcs[n][0] = pc1.get(); pcs[n][1] = pc2.get(); n++; pc0.increment(); obj.put(1); pcs[n][0] = pc1.get(); pcs[n][1] = pc2.get(); n++; pc0.increment(); }
        catch (Exception e) { pcs[n][0] = pc1.get(); pcs[n][1] = pc2.get(); n++; pc0.increment(); }
        
        result.r1 = "1@" + pcs[0][0] + ":" + "2@" + pcs[0][1] + "/" + "_" + ";" + "1@" + pcs[1][0] + ":" + "2@" + pcs[1][1] + "/" + r0 + ";" + "1@" + pcs[2][0] + ":" + "2@" + pcs[2][1] + "/" + "_" + ";" + "1@" + pcs[3][0] + ":" + "2@" + pcs[3][1] + "/" + "void";
    }
    
    @Actor
    public void actor1(StringResult3 result) {
        String r;
        Object r0;
        int pcs[][] = new int[2][2];
        int n = 0;
        
        try { pcs[n][0] = pc0.get(); pcs[n][1] = pc2.get(); n++; pc1.increment(); obj.put(0); pcs[n][0] = pc0.get(); pcs[n][1] = pc2.get(); n++; pc1.increment(); }
        catch (Exception e) { pcs[n][0] = pc0.get(); pcs[n][1] = pc2.get(); n++; pc1.increment(); }
        
        result.r2 = "0@" + pcs[0][0] + ":" + "2@" + pcs[0][1] + "/" + "_" + ";" + "0@" + pcs[1][0] + ":" + "2@" + pcs[1][1] + "/" + "void";
    }
    
    @Actor
    public void actor2(StringResult3 result) {
        String r;
        Object r0;
        int pcs[][] = new int[2][2];
        int n = 0;
        
        try { pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); n++; pc2.increment(); r = ResultAdapter.get(obj.get()); pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); n++; pc2.increment(); }
        catch (Exception e) { pcs[n][0] = pc0.get(); pcs[n][1] = pc1.get(); n++; pc2.increment(); r = ResultAdapter.get(e); }
        r0 = r;
        
        result.r3 = "0@" + pcs[0][0] + ":" + "1@" + pcs[0][1] + "/" + "_" + ";" + "0@" + pcs[1][0] + ":" + "1@" + pcs[1][1] + "/" + r0;
    }
}
