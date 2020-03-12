package cn.wuxiangknwo.java7.overrideTest;

/**
 * @Descirption
 * @Author WuXiang
 * @Date 2020/3/12/
 */
public abstract class Father {



    public String small(Object obj){
        System.out.println("obj"+obj);
        return obj.toString();
    }

    public String big(String obj){
        System.out.println("str"+obj);
        return obj.toString();
    }


    public Object smallReturn(Object obj){
        System.out.println("obj"+obj);
        return obj.toString();
    }

    public String bigReturn(Object obj){
        System.out.println("obj"+obj);
        return obj.toString();
    }


    public String smallAbstract(Object obj){
        System.out.println("obj"+obj);
        return obj.toString();
    }
}
