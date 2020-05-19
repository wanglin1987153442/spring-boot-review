package com.soft1851.threadstudy.ThreadPoolTestByMine;

/**
 * @author wl
 * @ClassNameMyTask
 * @Description 自定义线程池练习  任务类 我们要做的是什么  每个任务执行时间0.2秒
 * @Date 2020/5/19
 * @Version 1.0
 */
public class MyTask implements Runnable {
private Integer id;

    public MyTask(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "id=" + id +
                '}';
    }

    @Override
    public void run() {
        String name =Thread.currentThread().getName();
//        System.out.println("线程："+name+"即将执行："+id);
        //线程休眠时间
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程："+name+"完成任务："+id);
    }
}
