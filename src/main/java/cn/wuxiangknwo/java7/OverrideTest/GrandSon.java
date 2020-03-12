package cn.wuxiangknwo.java7.OverrideTest;

import org.junit.Test;

/**
 * @Descirption
 * @Author WuXiang
 * @Date 2020/3/12/
 */
public class GrandSon extends Son {
    @Test
    public void testInvoke(){
        GrandSon grandSon = new GrandSon();
        invoke(grandSon);
    }

    /*public void invoke(GrandSon son){
        System.out.println("GrandSon");
    }*/

    public void invoke(Son son){
        System.out.println("son");
    }

    public void invoke(Father father){
        System.out.println("father");
    }


}
