package com.soft1851.threadstudy.ThreadPoolTestByMine;

/**
 * @author wl
 * @ClassNameMyThreadPool
 * @Description TODO
 * @Date 2020/5/19
 * @Version 1.0
 */

import java.util.*;

/**
 * 自定义线程池
 * 成员变量：
 *      任务队列 集合  需要控制安全问题
 *      当前线程数量
 *      核心线程数量
 *      最大线程数量
 *      任务队列长度
 * 成员方法
 *     提交任务
 *        将任务提交到集合中 需要判断是否超出任务长度
 *     执行任务
 *         判断当前线程数量 决定创建核心线程还是非核心线程
 */
public class MyThreadPool {
   // 任务队列 集合  需要控制安全问题

    private List<Runnable>tasks= Collections.synchronizedList(new LinkedList<>());

    // 当前线程数量
    private   Integer  currentSize=0;
    // 核心线程数量
    private  Integer coreSize;
    // 最大线程数量
    private  Integer maxSize;
    //任务队列长度
    private  int workSize;

    public MyThreadPool(Integer coreSize, Integer maxSize, int workSize) {
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.workSize = workSize;
    }

    //提交任务

    public void submit(Runnable r){
        //判断集合重任务数量是否超出最大任务数量
        if (tasks.size()>=workSize){
            System.out.println("任务："+r+"被丢弃了");
        }else {
            tasks.add(r);
            //执行任务
            execTask(r);
        }
    }

    private void execTask(Runnable r) {
        //判断当前线程池是否超出核心线程数
        if (currentSize<coreSize){
            new MyWorker("核心线程数"+currentSize,tasks).start();
            currentSize++;
        }else if (currentSize<workSize){
            new  MyWorker("非核心线程"+currentSize,tasks).start();
            currentSize++;
        }else {
            System.out.println("任务："+r +"被缓存了");
        }
    }
}
