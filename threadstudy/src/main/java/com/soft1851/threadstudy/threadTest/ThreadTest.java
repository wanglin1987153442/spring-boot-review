package com.soft1851.threadstudy.threadTest;

/**
 * @author wl
 * @ClassNameThreadTest
 * @Description 实现一些简单线程方法
 * @Date 2020/5/19
 * @Version 1.0
 */
public class ThreadTest {

    public static void main(String[] args) {
        //优先级的设置
//        threadPriority();

//线程礼让
        threadYield();
    }


    /**
     * 设置线程优先级
     */
    private static void threadPriority() {
        //设置线程优先级  修改抢到cpu时间片的概率
        //优先级 0 10  默认是五


        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        };

        Thread t1 = new Thread(runnable, "Thread-1");
        Thread t2 = new Thread(runnable, "Thread-2");

        //设置优先级
        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        t2.start();
    }


    /**
     * 线程的礼让
     */
    private static void threadYield() {
        //线程礼让 指释放cpu资源重新争取
        Runnable r = new Runnable() {
            @Override
            public void run() {

                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                        if (i == 3) {
                            Thread.yield();
                        }
                    }



            }
        };
        Thread t1 = new Thread(r, "Thread-1");
        Thread t2 = new Thread(r, "Thread-2");


        t1.start();
        t2.start();

    }
}
