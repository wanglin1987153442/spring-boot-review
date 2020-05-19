package com.soft1851.threadstudy.threadTest;

import lombok.Data;

/**
 * @author wl
 * @ClassNameSynchronizeDemo
 * @Description TODO
 * @Date 2020/5/19
 * @Version 1.0
 */
public class SynchronizeDemo {

    public static void main(String[] args) {

        Runnable runnable = () -> {

            while (TicketCenter.ticketCount  >0) {
                //对象锁
//                synchronized ("") {
//                    if (TicketCenter.ticketCount <=0) {
//                        return;
//                    }
//                    System.out.println(Thread.currentThread().getName() + "卖出一张票 剩余" + --TicketCenter.ticketCount + "张");
//                }
                soldTicket();
            }
        };

        Thread t1 = new Thread(runnable, "Thread-1");
        Thread t2 = new Thread(runnable, "Thread-2");
        Thread t3 = new Thread(runnable, "Thread-3");
        Thread t4 = new Thread(runnable, "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

public synchronized static void soldTicket(){

        if (TicketCenter.ticketCount <=0) {
            return;
        }
        System.out.println(Thread.currentThread().getName() + "卖出一张票 剩余" + --TicketCenter.ticketCount + "张");

}

}
@Data
 class TicketCenter{
    public   static Integer ticketCount =100;
    }