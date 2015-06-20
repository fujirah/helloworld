package com.woom.tools.orginal.thread;

/**
 * Created by yuhao.zx on 14-12-27.
 */
public class Volatile implements Runnable{
    public volatile int i=0;
    public Integer a;
    @Override
    public void run() {
        while (i!=3){
            a = i;
            System.out.println(Thread.currentThread().getName()+"--"+a);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--next--"+a);
        }
    }

    public void A(){
        int c=i++;
    }

    public void B(){
        int c=++i;
    }
}
