package com.woom.tools.orginal.thread;

/**
 * Created by yuhao.zx on 15-1-18.
 */
public class JMMTest {
    public int a;
    public int b;
    public class Thread1 implements Runnable{
        @Override
        public void run() {
            while(true){
                a = 1;
                int x = b;
            }

        }
    }

    public class Thread2 implements Runnable{
        @Override
        public void run() {
            while(true){
                b = 2;
                int y = a;
            }
        }
    }
}
