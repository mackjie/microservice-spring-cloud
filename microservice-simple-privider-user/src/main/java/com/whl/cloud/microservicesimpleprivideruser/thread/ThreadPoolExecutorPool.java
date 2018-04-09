package com.whl.cloud.microservicesimpleprivideruser.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * UserThread
 * TODO:
 * 2018/4/810:35
 * 1.0
 * hlwu
 * 线程池工具类
 */
public class ThreadPoolExecutorPool{
    public static void main(String[] args) {
        //创建可缓存线程池：当线程池大小小于执行的线程数量，就会回收一部分空闲的线程（60s无执行），当有新的任务来时，又只能添加新线程执行
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //创建固定大小线程池: 如果执行的线程大于指定的线程数量就会进行处于等待状态 ，等待前面线程完成后才会执行
        //ExecutorService executorService = Executors.newFixedThreadPool(3);
        //单任务线程：只创建一个线程
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Thread thread1 = new CommonThread();
        Thread thread2 = new CommonThread();
        Thread thread3 = new CommonThread();
        Thread thread4 = new CommonThread();
        Thread thread5 = new CommonThread();
        //将创建好的线程放入线程池中
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);
        executorService.execute(thread4);
        executorService.execute(thread5);
        //关闭线程池:不允许再进行使用
        //executorService.shutdown();
        Thread thread6 = new CommonThread();
        executorService.execute(thread6);
    }
}

class CommonThread extends Thread{
    Object lock;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":正在被执行");
        synchronized(lock){
            //TODO

        }
        /*for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+":正在被执行"+i);
           try {
                Thread.sleep(Long.parseLong("1000"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}