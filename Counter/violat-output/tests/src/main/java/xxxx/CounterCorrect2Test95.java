package xxxx;

import java.util.Arrays;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import CounterCorrect2;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.*;

@JCStressTest
@Outcome(
    id = "2,\\s*3,\\s*4,\\s*5,\\s*6,\\s*1",
    expect = Expect.ACCEPTABLE,
    desc = "atomic")
@Outcome(
    id = "1,\\s*3,\\s*4,\\s*5,\\s*6,\\s*2",
    expect = Expect.ACCEPTABLE,
    desc = "atomic")
@Outcome(
    id = "1,\\s*2,\\s*4,\\s*5,\\s*6,\\s*3",
    expect = Expect.ACCEPTABLE,
    desc = "atomic")
@Outcome(
    id = "1,\\s*2,\\s*3,\\s*5,\\s*6,\\s*4",
    expect = Expect.ACCEPTABLE,
    desc = "atomic")
@Outcome(
    id = "1,\\s*2,\\s*3,\\s*4,\\s*6,\\s*5",
    expect = Expect.ACCEPTABLE,
    desc = "atomic")
@Outcome(
    id = "1,\\s*2,\\s*3,\\s*4,\\s*5,\\s*6",
    expect = Expect.ACCEPTABLE,
    desc = "atomic")
@State
public class CounterCorrect2Test95 {
    CounterCorrect2 obj = new CounterCorrect2();
    
    @Actor
    public void actor0(StringResult6 result) {
        String r;
        
        try { r = ResultAdapter.get(obj.incrementAndGet()); }
        catch (Exception e) { r = ResultAdapter.get(e); }
        result.r1 = r;
        
        try { r = ResultAdapter.get(obj.incrementAndGet()); }
        catch (Exception e) { r = ResultAdapter.get(e); }
        result.r2 = r;
        
        try { r = ResultAdapter.get(obj.incrementAndGet()); }
        catch (Exception e) { r = ResultAdapter.get(e); }
        result.r3 = r;
        
        try { r = ResultAdapter.get(obj.incrementAndGet()); }
        catch (Exception e) { r = ResultAdapter.get(e); }
        result.r4 = r;
        
        try { r = ResultAdapter.get(obj.incrementAndGet()); }
        catch (Exception e) { r = ResultAdapter.get(e); }
        result.r5 = r;
    }
    
    @Actor
    public void actor1(StringResult6 result) {
        String r;
        
        try { r = ResultAdapter.get(obj.incrementAndGet()); }
        catch (Exception e) { r = ResultAdapter.get(e); }
        result.r6 = r;
    }
}
