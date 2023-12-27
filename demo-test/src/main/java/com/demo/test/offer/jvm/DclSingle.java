package com.demo.test.offer.jvm;

/**
 * @author :xiezhi
 * @date : 2023/10/31
 * DCL单例模式
 */
public class DclSingle {
    private int i = 8;
    private static volatile DclSingle instance;

    public static DclSingle getInstance() {
        /*  这个if去掉不会影响线程安全性问题，但是这种写法和synchronized直接锁住方法差不多，锁的颗粒度太大
          不友好，这里加上if主要是为了判断大部分情况下，都不需要争抢这一把锁,性能大幅提升。
         */
        if(instance == null){
            synchronized (DclSingle.class){
            /*这个if是必须要加上的，和前面的if不同，如果这个if不加，那么就会出现线程安全问题，比如现在线程A,线程B同时都运行到了
            17行争抢锁，线程A抢到了，然后执行了new出来了对象，此时刚好退出同步块释放锁，然后线程B立即抢到了锁，由于没有判断会直接在new
            那么就是不同对象，不是单例了。
            * */
                if (instance == null){
                    /* 至于为什么volatile：
                    *  volatile主要有两个作用，第一个作用是线程间可见性，第二个是防止CPU执行优化指令重排序。
                    *  这里主要是用到的第二个作用，由于我们都知道对象的创建有先new一个空间（半初始化） 然后执行init初始化，最后指向
                    *  假如指向这条指令被优化了重排序了，那么有可能导致int中的i在极端情况下没有赋予给定值，会导致成员属性无法正确使用
                    * */
                    instance = new DclSingle();
                }
            }
        }
        return instance;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
