package cn.wuxiangknwo.java7.multiThread;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Descirption 多资源获取测试
 * @Author WuXiang
 * @Date 2020/3/25/
 */
public class MultiResourceTest {

    public static void main(String[] args) throws Exception{
        final MultiResource multiResource = new MultiResource(3);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                multiResource.handle();
            }
        };
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            threads.add(new Thread(runnable,"线程"+i));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

}
class MultiResource{

    private final int count;
    private int holdCount;
    public MultiResource(int count) {
        this.count = count;
        this.holdCount = 0;
    }

    public void handle(){
        try {
            while (!acquire()){
                synchronized (this){
                    this.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //处理资源
            System.out.println(Thread.currentThread().getName()+"处理资源中");
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            release();
        }
    }

    private synchronized boolean  acquire(){
        if(holdCount < count){
            holdCount++;
            return true;
        }else{
            return false;
        }
    }

    private synchronized void  release(){
        holdCount--;
        System.out.println(Thread.currentThread().getName()+"已释放资源");
        this.notifyAll();
    }

}

