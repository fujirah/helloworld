package com.woom.tools.orginal.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuhao.zx on 15-1-20.
 */
public class HashMapTester {
    static int i = 0;
    static Map<Integer,Integer>  map = new HashMap<Integer, Integer>();
    public static class Thread1 implements Runnable{
        @Override
        public void run() {
            while (true){
                map.put((int)(Math.random()*1000),(int)(Math.random()*10)) ;
                if(map.size() >= 100){
                    System.out.println("size full times "+i++);
                    map = new HashMap<Integer, Integer>();
                }
            }
        }
    }

    public static class Thread2 implements Runnable{
        @Override
        public void run() {
            while(true){
                map.put((int)(Math.random()*1000),(int)(Math.random()*10)) ;
                if(map.size() == 100){
                    System.out.println("size full times "+i++);
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new HashMapTester.Thread1());
        Thread t2 = new Thread(new HashMapTester.Thread2());
        t1.start();
        t2.start();
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
