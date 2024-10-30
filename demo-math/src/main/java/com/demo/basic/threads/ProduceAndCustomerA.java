package com.demo.basic.threads;


/**
 之前已经说道，JVM提供了synchronized关键字来实现对变量的同步访问以及用wait和notify来实现线程间通信。
 @see ProduceAndCustomer
 在jdk1.5以后，JAVA提供了Lock类来实现和synchronized一样的功能，并且还提供了Condition来显示线程间通信。
 Lock类是Java类来提供的功能，丰富的api使得Lock类的同步功能比synchronized的同步更强大。
 Lock类实际上是一个接口，我们在实例化的时候实际上是实例化实现了该接口的类Lock lock = new ReentrantLock();。
 * */
public class ProduceAndCustomerA {
}
