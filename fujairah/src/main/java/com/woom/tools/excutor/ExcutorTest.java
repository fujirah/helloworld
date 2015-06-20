package com.woom.tools.excutor;

import javax.security.auth.callback.Callback;
import java.util.concurrent.*;

/**
 * Created by yuhao.zx on 2015/3/22.
 */
public class ExcutorTest {
    static int i = 0;
    static ExecutorService executorService;

    /**
     * 测试表明，如果不显示地调用shutdown函数，那么此线程将永远不会停止
     */
    public static void singleThreadExecutor(){
        executorService = Executors.newSingleThreadExecutor();

        for(int j = 0 ;j < 100 ;j++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(i++);
                }
            });
        }
    }

    /**
     * Future 和 Callable 测试
     * 如果使用Callable而不使用Runable接口，那么是可以返回结果的，用Future来接收
     */
    public static void callbackMethod(){
        executorService = Executors.newSingleThreadExecutor();
        Future f = executorService.submit(new MyCallback());
        try {
            if(f.isCancelled())
                System.out.println(f.get());
            else
                System.out.printf("not done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static class MyCallback implements Callable<String>{

        @Override
        public String call() throws Exception {
            if(i % 2==0){
                Thread.sleep(1000);
                return "double";
            }else {
                Thread.sleep(1000);
                return "single";
            }

        }
    }

    /**
     * 测试表明，如果不显示地调用shutdown函数，那么此线程将永远不会停止
     */
    public static void fixedThreadExecutor(){
        executorService = Executors.newFixedThreadPool(10);

        for(int j = 0 ;j < 100 ;j++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(i++);
                }
            });
        }
    }

    public static void main(String[] args) {
//        callbackMethod();
        fixedThreadExecutor();
        executorService.shutdown();


    }

}
