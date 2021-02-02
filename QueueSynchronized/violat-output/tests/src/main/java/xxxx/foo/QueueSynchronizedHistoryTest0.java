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
public class QueueSynchronizedHistoryTest0 {
    QueueSynchronized obj = new QueueSynchronized();
    NoReorderCounter pc0 = new NoReorderCounter();
    NoReorderCounter pc1 = new NoReorderCounter();
    
    @Actor
    public void actor0(StringResult2 result) {
        String r;
        Object r0, r1;
        int pcs[][] = new int[4][1];
        int n = 0;
        
        try { pcs[n][0] = pc1.get(); n++; pc0.increment(); obj.put(1); pcs[n][0] = pc1.get(); n++; pc0.increment(); }
        catch (Exception e) { pcs[n][0] = pc1.get(); n++; pc0.increment(); }
        
        try { pcs[n][0] = pc1.get(); n++; pc0.increment(); obj.put(1); pcs[n][0] = pc1.get(); n++; pc0.increment(); }
        catch (Exception e) { pcs[n][0] = pc1.get(); n++; pc0.increment(); }
        
        result.r1 = "1@" + pcs[0][0] + "/" + "_" + ";" + "1@" + pcs[1][0] + "/" + "void" + ";" + "1@" + pcs[2][0] + "/" + "_" + ";" + "1@" + pcs[3][0] + "/" + "void";
    }
    
    @Actor
    public void actor1(StringResult2 result) {
        String r;
        Object r0;
        int pcs[][] = new int[2][1];
        int n = 0;
        
        try { pcs[n][0] = pc0.get(); n++; pc1.increment(); obj.put(0); pcs[n][0] = pc0.get(); n++; pc1.increment(); }
        catch (Exception e) { pcs[n][0] = pc0.get(); n++; pc1.increment(); }
        
        result.r2 = "0@" + pcs[0][0] + "/" + "_" + ";" + "0@" + pcs[1][0] + "/" + "void";
    }
}
