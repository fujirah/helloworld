package com.woom.tools.orginal.thread;

/**
 * Created by yuhao.zx on 15-1-2.
 */
public class DeadLock implements Runnable{
    public static boolean seprate;
    @Override
    public void run() {
        if(!seprate){
            catch1();
        }else {
            catch2();
        }
    }

    private synchronized void catch1(){
        System.out.println(Thread.currentThread().getId()+"in catch1 start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch2();
        System.out.println(Thread.currentThread().getId()+"in catch1 end");
    }

    private synchronized void catch2(){
        System.out.println(Thread.currentThread().getId()+"in catch2 start");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId()+"in catch2 end");
    }
}
