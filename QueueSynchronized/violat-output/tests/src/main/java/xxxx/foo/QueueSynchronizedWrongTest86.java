package xxxx.foo;

import java.util.Arrays;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.foo.QueueSynchronizedWrong;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.*;

@JCStressTest
@Outcome(
    id = "",
    expect = Expect.ACCEPTABLE,
    desc = "atomic")
@State
public class QueueSynchronizedWrongTest86 {
    QueueSynchronizedWrong obj = new QueueSynchronizedWrong();
    
    @Actor
    public void actor0(StringResult0 result) {
        String r;
        
        try { obj.put(1); }
        catch (Exception e) { }
        
        try { obj.put(1); }
        catch (Exception e) { }
        
        try { obj.put(0); }
        catch (Exception e) { }
    }
    
    @Actor
    public void actor1(StringResult0 result) {
        String r;
        
        try { obj.put(0); }
        catch (Exception e) { }
        
        try { obj.put(0); }
        catch (Exception e) { }
    }
}
