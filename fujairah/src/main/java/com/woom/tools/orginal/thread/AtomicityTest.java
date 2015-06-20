package com.woom.tools.orginal.thread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yuhao.zx on 14-12-28.
 */
public class AtomicityTest implements Runnable {
    private AtomicInteger i = new AtomicInteger(0);
    public int getValue(){return i.get();}
    private void evenIncremnet(){

        i.addAndGet(2);
    }
    @Override
    public void run() {
        while (true){
            evenIncremnet();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        },5000);
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while(true){
            int val = at.getValue();
            if(val % 2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
