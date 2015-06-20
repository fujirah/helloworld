package com.woom.tools.orginal.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yuhao.zx on 15-1-20.
 */
public class ConCurrentHashMapTest {
    static int MAX = 10000000;
    static int i = 0;
    static Map<Integer,Integer> map = new ConcurrentHashMap<Integer, Integer>();
    public static class Thread1 implements Runnable{
        @Override
        public void run() {
            while (true){
                map.put((int)(Math.random()*100),(int)(Math.random()*10)) ;
                if(map.size() >= 100){
                    System.out.println("size full times "+i++);
                    map = null;
                    map = new ConcurrentHashMap<Integer, Integer>();
                }
            }
        }
    }

    public static class Thread2 implements Runnable{
        @Override
        public void run() {
            while(i < MAX){
                map.put((int)(Math.random()*100),(int)(Math.random()*10)) ;
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
