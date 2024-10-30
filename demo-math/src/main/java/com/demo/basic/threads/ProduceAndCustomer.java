package com.demo.basic.threads;


/**
 * 交替打印问题，比如有两个线程AB，A输出1，B输出2，A输出3依此类推一直打印到100
 * synchronized 同步代码块wait() notify() notifyAll()
 * wait() 和 notify() 是 Java 的 Object 类中的两个方法，它们被用于多线程间的协作。
 * 具体来说，这两个方法被设计用来在并发编程中处理线程间的通信问题，
 * 允许线程等待某个条件成立或通知其他线程某个条件已经满足。
 *
 * wait() 方法使得当前线程（调用 wait() 的线程）进入等待状态(阻塞并释放锁)，
 * 直到其他线程调用同一个对象的 notify() 或 notifyAll() 方法。
 notify() notify并不释放锁，只是告诉调用过wait方法的线程可以去参与获得锁的竞争了，但不是马上得到锁，因为锁还在别人手里，别人还没释放
 *
 当前线程必须拥有此对象的monitor（即锁），才能调用某个对象的wait()方法能让当前线程阻塞，不然报错。


wait，notify，notifyAll都是Object对象的final方法。
wait()调用之后会立即释放对象锁。
notify() 和 notifyAll()  不会立即释放对象锁。notify()是在等待队列中随机抽取一个线程，
notifyAll()是将队列中的所有线程执行唤醒动作，
在notify()方法所在代码块执行完毕之后才释放对象锁，此时被唤醒的线程才有可能执行。


 在Java中，sleep方法是Thread类的静态方法，它用于将当前正在执行的线程暂停指定的时间，
 让出CPU给其他线程，但是它并不会释放对象锁。也就是说，如果当前线程持有对某个对象的锁，
 在调用sleep方法后，其他线程仍然不能访问那个对象。



 * */
public class ProduceAndCustomer {


    //private static Integer i = 1; //初始共享资源 ，不能用这个当共享变量，主要是interger缓存池问题 https://blog.csdn.net/An_light/article/details/138854228

    static class IntegerValue{
        int i = 1;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }


    static IntegerValue integerValue = new IntegerValue();
    static Object lock = new Object();


    Thread  a = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true){
                synchronized (integerValue){
                    if(integerValue.getI()>100){
                        //防止最后一次被B线程唤醒之后，发现超过100，则直接抛出。线程执行完毕。
                        // 如果不唤醒，那么B线程一直停留再wait方法那边，线程B阻塞无法结束。
                        integerValue.notify();
                        break;
                    }
                    System.out.println(a.getName()+integerValue.getI());
                    integerValue.setI(integerValue.getI()+1);
                    //通知同步代码快的调用对象的其它线程执行
                    integerValue.notify();
                    try {
                        //等待被唤醒并释放锁
                        integerValue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    },"线程A");



    Thread  b = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true){
                synchronized (integerValue){
                    if(integerValue.getI()>100){
                        integerValue.notify();
                        break;
                    }
                    System.out.println(b.getName()+integerValue.getI());
                    integerValue.setI(integerValue.getI()+1);
                    //通知同步代码快的调用对象的其它线程执行
                    integerValue.notify();
                    try {
                        //等待被唤醒并释放锁
                        integerValue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    },"线程B");



    static  int cnt = 1;
    static class thread1 extends Thread{
        @Override
        public void run() {
            while(true) {

                synchronized (lock) {
                    if(cnt > 100) {
                        lock.notifyAll();
                        break;
                    }
                    System.out.println("线程A打印: " + cnt);
                    cnt++;
                    lock.notifyAll();
                    try{
                        lock.wait();
                    }catch (InterruptedException ex){}
                }
            }

        }
    }
    static class thread2 extends Thread{
        @Override
        public void run() {
            while(true) {

                synchronized (lock) {
                    if(cnt > 100) break;
                    System.out.println("线程B打印: " + cnt);
                    cnt++;
                    lock.notifyAll();
                    try{
                        lock.wait();
                    }catch (InterruptedException ex){}
                }
            }
        }
    }


    public static void main(String[] args) {
        ProduceAndCustomer customer = new ProduceAndCustomer();
        customer.b.start();
        customer.a.start();


        /*Thread t1 = new thread1();
        Thread t2 = new thread2();
        t1.start();t2.start();*/
    }

}
