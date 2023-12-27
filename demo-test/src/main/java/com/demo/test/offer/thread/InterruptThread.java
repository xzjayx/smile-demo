package com.demo.test.offer.thread;

/**
 * @author :xiezhi
 * @date : 2023/11/13
 * 线程中断
 */
public class InterruptThread {

    public static void main(String[] args) {
        //获取当前线程的中断标记位（interrupt），默认为false
        System.out.println(Thread.currentThread().isInterrupted()); // false

        //修改线程的中断标记位为true
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted()); // true


        //获取当前线程的中断标记位（interrupt），并且把中断标记位（interrupt）归位为false
        System.out.println(Thread.interrupted()); // true 当前为true，之后归位
        System.out.println(Thread.currentThread().isInterrupted());// false

        /*Thread t1 = new Thread(() ->{
            while ()
        });*/
    }

}
