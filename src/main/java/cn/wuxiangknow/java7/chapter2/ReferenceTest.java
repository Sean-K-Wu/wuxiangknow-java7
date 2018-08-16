package cn.wuxiangknow.java7.chapter2;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 *
 * 关于强引用,弱引用,软引用,虚引用的测试
 * Created by x7430 on 2018/8/16.
 */
public class ReferenceTest {


    /**
     * 强引用  引用存在就不会回收,哪怕抛出内存异常
     */
    @Test
    public void testStrongRef(){
        Object o = new Object();
        System.gc();
        System.out.println(o);
    }

    /**
     * 软引用 只有内存空间不足时会进行回收
     */
    @Test
    public void  testSoftRef(){
        Object o = new Object();
        SoftReference<Object> sfRO = new SoftReference<>(o);
        o = null;
        System.gc();
        System.out.println(sfRO.get());
    }

    /**
     * 弱引用 只要扫描到就会回收(不管内存空间是否充足)
     */
    @Test
    public void testWeakRef(){
        Object o = new Object();
        WeakReference<Object> wkRO = new WeakReference<>(o);
        o = null;
        System.gc();
        System.out.println(wkRO.get());
    }

    /**
     * 虚引用  任何时刻都有可能被回收,且get方法总是返回null;如果被回收,ReferenceQueue中会被添加虚引用
     */
    @Test
    public void testPhantomRef(){
        ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        Object o = new Object();
        PhantomReference<Object> ptRO = new PhantomReference<>(o, refQueue);
        o = null;
        System.gc();
        System.out.println(ptRO.get());
    }

}
