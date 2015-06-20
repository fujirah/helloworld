package com.woom.tools;

import com.woom.tools.common.Context;
import com.woom.tools.guava.Tester;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by yuhao.zx on 14-12-7.
 */
public class Mytester extends TestCase{
    public static void main(String[] args) {
        Tester t = (Tester) Context.getBean("test");
        t.hello();
    }
    @Test
    public void test(){
        Tester t = (Tester) Context.getBean("test");
        t.hello();
    }
}