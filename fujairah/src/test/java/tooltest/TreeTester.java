package tooltest;

import com.woom.tools.algorithm.tree.BinarySortTree;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by yuhao.zx on 2015/4/11.
 */
public class TreeTester extends TestCase {
    @Test
    public void testBST(){
        BinarySortTree bst = new BinarySortTree();
        bst.put(1);
        bst.put(-56);
        bst.put(4);
        bst.put(676);
        bst.put(23);
        bst.put(33);
        bst.put(5);

        bst.view();
    }
}
