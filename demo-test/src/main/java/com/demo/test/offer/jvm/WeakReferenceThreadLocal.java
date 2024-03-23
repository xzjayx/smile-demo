package com.demo.test.offer.jvm;

import java.lang.ref.WeakReference;

/**
 * @author 57824
 * 虚引用ThreadLocal代码分析
 */
public class WeakReferenceThreadLocal {

    public static void main(String[] args) {
        //一个对象A里面有一个弱引用对象B，那么每当GC的情况出现操作的时候就会直接回收这个弱引用对象B。常见ThreadLocal
        /*WeakReference<Mg>  m = new WeakReference<>(new Mg());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());*/

        //ThreadLocal 程本地对象，每一个线程独享，无论读取还是写入都仅仅对当前线程有效，线程之间隔离
        ThreadLocal<Mg>  threadLocal = new ThreadLocal<>();
        threadLocal.set(new Mg());
        threadLocal.remove();

        /*new Thread(()->{
            System.out.println(Thread.currentThread());
        },"t1").start();*/



    }
}

class Mg{

    @Override
    protected void finalize() throws Throwable {
        System.out.println("被GC回收执行");
    }
}
