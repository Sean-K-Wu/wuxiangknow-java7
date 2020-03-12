package cn.wuxiangknwo.java7.OverrideTest;

/**
 * @Descirption
 * @Author WuXiang
 * @Date 2020/3/12/
 */
public class Son extends Father {
    //@Override
    public String small(String obj){
        System.out.println("son str"+obj);
        return obj.toString();
    }

    //@Override
    public String big(Object obj){
        System.out.println("son obj"+obj);
        return obj.toString();
    }

    @Override
    public String smallReturn(Object obj){
        System.out.println("son obj"+obj);
        return obj.toString();
    }
    //@Override
    /*public Object bigReturn(Object obj){
        System.out.println("obj"+obj);
        return obj;
    }*/
    //@Override
    public String smallAbstract(String obj){
        System.out.println("son obj"+obj);
        return obj.toString();
    }
}
