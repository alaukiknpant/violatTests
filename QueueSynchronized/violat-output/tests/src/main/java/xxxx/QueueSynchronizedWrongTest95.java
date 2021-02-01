package xxxx;

import java.util.Arrays;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import QueueSynchronizedWrong;
import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.*;

@JCStressTest
@Outcome(
    id = "QueueWithoutAnySync\\{indGet=0,\\s*indPut=0,\\s*countElements=0,\\s*items=\\[0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0\\]\\}",
    expect = Expect.ACCEPTABLE,
    desc = "atomic")
@Outcome(
    id = "QueueWithoutAnySync\\{indGet=0,\\s*indPut=1,\\s*countElements=1,\\s*items=\\[0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0\\]\\}",
    expect = Expect.ACCEPTABLE,
    desc = "atomic")
@Outcome(
    id = "QueueWithoutAnySync\\{indGet=0,\\s*indPut=2,\\s*countElements=2,\\s*items=\\[0,\\s*1,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0,\\s*0\\]\\}",
    expect = Expect.ACCEPTABLE,
    desc = "atomic")
@State
public class QueueSynchronizedWrongTest95 {
    QueueSynchronizedWrong obj = new QueueSynchronizedWrong();
    
    @Actor
    public void actor0(StringResult1 result) {
        String r;
        
        try { obj.put(0); }
        catch (Exception e) { }
        
        try { obj.put(1); }
        catch (Exception e) { }
    }
    
    @Actor
    public void actor1(StringResult1 result) {
        String r;
        
        try { r = ResultAdapter.get(obj.toString()); }
        catch (Exception e) { r = ResultAdapter.get(e); }
        result.r1 = r;
        
        try { obj.put(1); }
        catch (Exception e) { }
    }
}
