package cn.wuxiangknwo.java7.extendsTest;

import java.lang.reflect.Field;

/**
 * @Descirption
 * @Author WuXiang
 * @Date 2020/3/27/
 */
public class Son extends Father {

    private Integer weight;


    public static void main(String[] args) throws Exception{
        Son son = (Son) Son.class.getConstructors()[0].newInstance(null);
        Field[] fields = Son.class.getFields();
        Field[] declaredFields = Son.class.getDeclaredFields();
        Field name = Son.class.getSuperclass().getDeclaredField("name");
        name.setAccessible(true);
        System.out.println( name.get(son));

    }
}
