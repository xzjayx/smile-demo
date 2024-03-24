package com.demo.test.offer.thread;

/**
 * @author wuqian
 * 线程交替打印  1A2B3C4D5E.....
 */
public class AlternatePrint {

    private static Integer[] number = {1,2,3,4,5,6,7,8,9,10};
    private static String[] alphabet = {"a","b","c","d","e","f","g","h","i","j"};

    private static final String lock = "LOCK";

    public static void main(String[] args) {
        Thread t1  = new Thread(() -> {
            try {
                synchronized (lock){
                    for (Integer c : number) {
                        System.out.print(c);
                        lock.notify();
                        lock.wait();//表示当前线程让出锁，进入阻塞队列，等待其余线程唤醒才能走
                    }
                    //这个notify必须加，不然程序结束不了。因为最后都是wait(),都是阻塞状态，必须要唤醒对方才能结束
                    lock.notify();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (lock){
                        for (String c : alphabet) {
                            System.out.print(c);
                            lock.notify();
                            lock.wait();
                        }
                        //这个notify必须加，不然程序结束不了。
                        lock.notify();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();



    }

}
