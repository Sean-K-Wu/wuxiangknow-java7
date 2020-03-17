package cn.wuxiangknow;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }



    @Test
    public void youhua(){
        double l;
        long then = System. currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            l = fibImpl1( 1);
        }
        long now = System. currentTimeMillis();
        System. out. println(" Elapsed time: " + (now - then));
    }



    private double fibImpl1(int n){
        if (n < 0) throw new IllegalArgumentException(" Must be > 0");
        if (n == 0) return 0d;
        if (n == 1) return 1d;
        double d = fibImpl1( n - 2) + fibImpl1( n - 1);
        if (Double. isInfinite( d)) throw new ArithmeticException(" Overflow");
        return d;
    }
}
