package JCS_Test;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.J_Result;

@JCStressTest
@Outcome(id = "0",expect = Expect.ACCEPTABLE,desc = "seeing the default value:write ")
@Outcome(id = "1",expect = Expect.ACCEPTABLE,desc = "seeing the full value ")
@Outcome(expect = Expect.ACCEPTABLE_INTERESTING,desc = "Other cases are violating access atomicity")
@State
public  class Longs {
    long v;
    @Actor
    public void writer(){
        v = 0xFFFFFFFF_FFFFFFFFL;
    }
    @Actor
    public void reader(J_Result r){
        r.r1 = v;
    }
}
