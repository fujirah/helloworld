package tooltest;

import com.woom.tools.guava.Tester;
import com.woom.tools.orginal.thread.DeadLock;
import com.woom.tools.orginal.thread.MyLock;
import org.junit.After;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

/**
 * Created by yuhao.zx on 15-1-2.
 *
 * 单元测试中如果主线程完成了，那么会将其他线程杀死，不会等待其执行
 */

@ContextConfiguration(locations = { "classpath*:test/effective.xml" })
public class ToolTester extends AbstractJUnit4SpringContextTests{
    @Resource
    private Tester tester;
    @Test
    public void test(){
        tester.hello();
    }

    /**
     * 测试表明
     * 1:通过synchronized拿不到锁，那么将会进入等待
     * 2:thread.start()只能调用一次
     * 3:一旦synchronized方法运行，那么它下面的所有包含synchronized的方法将会被锁住，其他调用方不可调用
     * 4:synchronized方法针对的是当前实例，如果两个不同实例这个将无效(如果是静态方法则有效)
     *
     *  */
    @Test
    public void deadLockTest(){
        try {
            DeadLock deadLock = new DeadLock();
            Thread t1 = new Thread(deadLock);
            Thread t2 = new Thread(deadLock);

            t1.start();
            Thread.sleep(500);
            deadLock.seprate=true;
            t2.start();
            Thread.sleep(15000);
            System.out.println("这是一个分割线------------------");
            deadLock.seprate=false;
            t1 = new Thread(new DeadLock());
            t1.start();
            Thread.sleep(500);
            deadLock.seprate=true;
            t2 = new Thread(new DeadLock());
            t2.start();
            Thread.sleep(15000);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * 测试表明：
     * 1.Lock可以去尝试获取锁，如果获取不到可以不选择等待，做其他的事情
     */
    @Test
    public void myLockTest(){
        MyLock myl = new MyLock();
        Thread t1 = new Thread(myl.getThread("thread1"));
        Thread t2 = new Thread(myl.getThread("thread2"));
        t1.start();
        t2.start();

    }

    /**
     * 测试表明：
     * 1.ReentrantLock 定义在哪里，那么它的作用域就在哪里
     */
    @Test
    public void myLockTest1(){
        MyLock myl1 = new MyLock();
        MyLock myl2 = new MyLock();
        Thread t1 = new Thread(myl1.getThread("thread1"));
        Thread t2 = new Thread(myl2.getThread("thread2"));
        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("this is a line ----------------------------------");

        t1 = new Thread(myl1.getThread2("thread1"));
        t2 = new Thread(myl2.getThread2("thread2"));
        t1.start();
        t2.start();
    }

    @After
    public void after(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
