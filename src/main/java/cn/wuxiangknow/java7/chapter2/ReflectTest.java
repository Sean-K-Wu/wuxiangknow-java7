package cn.wuxiangknow.java7.chapter2;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 反射测试
 * Created by x7430 on 2018/8/16.
 */
public class ReflectTest {


    @Test
    public void testProxy(){
        ClassLoader classLoader = Template.class.getClassLoader();

        Object o = Proxy.newProxyInstance(classLoader, Template.class.getInterfaces(), new ProxyClass());



    }


}

class ProxyClass implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxy,args);
    }
}