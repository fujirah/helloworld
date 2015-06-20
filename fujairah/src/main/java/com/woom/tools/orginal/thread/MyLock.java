package com.woom.tools.orginal.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yuhao.zx on 15-1-3.
 */
public class MyLock {
    private Lock lock = new ReentrantLock();
    public static Lock lockStatic = new ReentrantLock();

    public class Thread1 implements Runnable{
        public String name;
        public Thread1(String name){
            this.name = name;
        }
        @Override
        public void run() {
            boolean l =  lock.tryLock();
            if(l){
                try {
                    lock.lock();
                    Thread.sleep(1000);
                    System.out.println(name+" in running");
                }catch (Exception e){
                    System.out.println(e);
                }finally {
                    lock.unlock();
                }
            }else{
                System.out.println(name+" can't get lock!");
            }
        }
    }

    public class Thread2 implements Runnable{
        public String name;
        public Thread2(String name){
            this.name = name;
        }
        @Override
        public void run() {
            boolean l =  lockStatic.tryLock();
            if(l){
                try {
                    lockStatic.lock();
                    Thread.sleep(1000);
                    System.out.println(name+" in running");
                }catch (Exception e){
                    System.out.println(e);
                }finally {
                    lockStatic.unlock();
                }
            }else{
                System.out.println(name+" can't get lock!");
            }
        }
    }

    public Runnable getThread(String name){
        return new Thread1(name);
    }

    public Runnable getThread2(String name){
        return new Thread2(name);
    }
}
