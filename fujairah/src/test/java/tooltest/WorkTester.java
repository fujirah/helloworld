package tooltest;

import com.woom.work.Basefee;
import junit.framework.TestCase;

/**
 * Created by yuhao.zx on 15-3-9.
 */
public class WorkTester extends TestCase {
    public void testBaseFee(){
        Basefee.computer(0L,3000L,2500L,1250L);
    }
}
