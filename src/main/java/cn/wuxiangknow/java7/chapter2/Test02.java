package cn.wuxiangknow.java7.chapter2;


import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Desciption 测试
 * @Author WuXiang
 * @Date 2018/8/5 17:44
 */
public class Test02 {


    @Test
    public void testContructor(){
        try {
            Class<PrivateConstructorClass> aClass = (Class<PrivateConstructorClass>) Class.forName(PrivateConstructorClass.class.getName());
            Constructor<?>[] constructors = aClass.getConstructors();
            System.out.println(constructors.length);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
