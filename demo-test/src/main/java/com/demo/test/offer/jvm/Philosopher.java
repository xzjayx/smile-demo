package com.demo.test.offer.jvm;

import lombok.SneakyThrows;

/**
 * @author 57824
 * 哲学家就餐问题，哲学家对象
 * 主要考验死锁问题
 */
public class Philosopher extends Thread{
    /**
     * 哲学家编号
     */
    private  Integer index;
    /**
     * 左边筷子
     */
    private final Chopsticks left;
    /**
     * 右边筷子
     */
    private final Chopsticks right;

    public Philosopher(Integer index, Chopsticks left, Chopsticks right) {
        this.index = index;
        this.left = left;
        this.right = right;
    }

    @SneakyThrows
    @Override
    public void run() {
        //每一个哲学家先抢左边的筷子在抢右边的筷子 ，当前代码会死锁。
        synchronized (left){
            Thread.sleep(index+ 1000);
            System.out.println("第"+index+"号哲学家抢到了左边的筷子");
            synchronized (right){
                Thread.sleep(index);
                System.out.println("第"+index+"号哲学家抢到右边的筷子开始吃完饭了");
            }
        }

    }

    public static void main(String[] args) {

        Chopsticks  c1 = new Chopsticks(1);
        Chopsticks  c2 = new Chopsticks(2);
        Chopsticks  c3 = new Chopsticks(3);
        Chopsticks  c4 = new Chopsticks(4);
        Chopsticks  c5 = new Chopsticks(5);

        Philosopher p1 = new Philosopher(1,c5,c1);
        Philosopher p2 = new Philosopher(2,c1,c2);
        Philosopher p3 = new Philosopher(3,c2,c3);
        Philosopher p4 = new Philosopher(4,c3,c4);
        Philosopher p5 = new Philosopher(5,c4,c5);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();


    }




}
