package cn.wuxiangknwo.java7.volatileTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Desciption
 * @Author WuXiang
 * @Date 2019/10/11 22:56
 */
public class ListTest {

    @Test
    public void testValue() throws InterruptedException {

        byte a = 1;
        byte b = 1;
        byte c = 1;
        ArrayList<Byte> bytes = new ArrayList<>();
        bytes.add(a);
        bytes.add(b);
        bytes.add(c);
        bytes.remove(c);
        System.out.println(bytes.size());
    }


    public static void main(String[] args) {
        byte[] bytes = new byte[64];
        new Random().nextBytes(bytes);
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes));
    }



    class VolatileDto{

        private volatile int x;

        private void write() {
            x = 5;
        }
        private void read() {
            while (x != 5) {
            }
            if(x == 5){
                System.out.println("------stop");
            }
        }
    }
}


