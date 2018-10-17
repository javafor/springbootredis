package com.example.demo.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 1 on 2018/10/15.
 */
public class Runable implements Runnable {
    private int i;
    public Runable(int i){
        this.i=i;
    }
    public static void main(String[] args) {
       /* for (int a=0;a<10;a++){
            Thread t1=new Thread(new Runable(a));
            threadable t2=new threadable(a);
            t1.start();
            t1.start();
            t2.run();
            t2.run();
        }*/

        ExecutorService runnableService = Executors.newFixedThreadPool(3);

        Runable r1 = new Runable(1);
        Runable r2 = new Runable(2);
        Runable r3 = new Runable(3);
        Runable r4 = new Runable(4);
        runnableService.submit(r1);
        runnableService.submit(r2);
        runnableService.submit(r3);
        runnableService.submit(r4);
        runnableService.shutdown();

        System.out.println("go on");
        System.out.println("end");
    }
    @Override
    public void run() {
        System.out.println("多线程runable"+i);
    }
}
class threadable extends Thread{
    private int i;
    public threadable(int i) {
        this.i=i;
    }
    public void run() {
        System.out.println("多线程thread"+i);
    }
}