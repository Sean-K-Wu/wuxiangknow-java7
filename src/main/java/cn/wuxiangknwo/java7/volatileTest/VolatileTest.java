package cn.wuxiangknwo.java7.volatileTest;

import org.junit.Test;

/**
 * @Desciption
 * @Author WuXiang
 * @Date 2019/10/11 22:56
 */
public class VolatileTest {

    volatile VolatileDto volatileDto = new VolatileDto();
    VolatileDto noVolatileDto = new VolatileDto();

    @Test
    public void testValue() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
                int count = 0;
                while (true) {
                    volatileDto.setName(String.valueOf(count));
                    noVolatileDto.setName(String.valueOf(count));
                    count++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    //System.out.println("thread2:volatile{}"+volatileDto.getName());
                    System.out.println("thread2:{}"+noVolatileDto.getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread3 = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    //System.out.println("thread3:volatile{}"+volatileDto.getName());
                    System.out.println("thread3:{}"+noVolatileDto.getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread2.start();
        thread3.start();
        thread1.start();
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReference() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    volatileDto =new VolatileDto();
                    noVolatileDto =new VolatileDto();
                    System.out.println("当前正确值:"+noVolatileDto);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    //System.out.println("thread2:volatile{}"+volatileDto);
                    System.out.println("thread2:{}"+noVolatileDto);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread3 = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    //System.out.println("thread3:volatile{}"+volatileDto);
                    System.out.println("thread3:{}"+String.valueOf(noVolatileDto));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread2.start();
        thread3.start();
        thread1.start();
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    class VolatileDto{

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}


