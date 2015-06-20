package com.woom.tools.orginal.thread;

/**
 * Created by yuhao.zx on 14-12-27.
 */
public class ThreadTester {
    public static void main(String[] args) {
        Volatile v = new Volatile();
        Thread t = new Thread(v);
        v.i=1;
        t.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(v);
        v.i=2;
        t2.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        v.i=3;

    }
}
