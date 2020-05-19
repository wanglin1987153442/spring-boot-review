package com.soft1851.threadstudy.ThreadPoolTestByMine;

import java.util.List;

/**
 * @author wl
 * @ClassNameMyWorker
 * @Description 编写线程类需要继承线程类，设计一个属性 保存线程名字 保存所有人物
 * @Date 2020/5/19
 * @Version 1.0
 */
public class MyWorker extends Thread{
    private String name;
    //保存线程名字

    private List<Runnable> tasks;


    public MyWorker(String name, List<Runnable> tasks) {
        this.name = name;
        this.tasks = tasks;
    }
    @Override
    public void run(){
        //判断集合中是否有任务，只要有，就一直执行。
        while (tasks.size()>0){

            Runnable r=tasks.remove(0);
            System.out.println(r);
            //执行任务
            r.run();
        }
    }


}
