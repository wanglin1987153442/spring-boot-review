package com.soft1851.threadstudy.ThreadPoolTestByMine;

/**
 * @author wl
 * @ClassNameMyTest
 * @Description TODO
 * @Date 2020/5/19
 * @Version 1.0
 */
public class MyTest {
    public static void main(String[] args) {
        //创建线程池对象
        //核心线程数=任务数量*执行时间  列如 10个任务  每个任务时间 0.2秒  任务队列长度  最大长度 减去 核心数 /时间 *2
        MyThreadPool myThreadPool=new MyThreadPool(2,4,20);

        //提交任务
        for (int i = 0; i <30 ; i++) {
           MyTask myTask=new MyTask(i);

           myThreadPool.submit(myTask);
        }



    }
}
