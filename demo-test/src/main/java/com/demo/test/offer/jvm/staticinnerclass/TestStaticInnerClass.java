package com.demo.test.offer.jvm.staticinnerclass;

/**
 * @author 57824
 * 问题：static class 修饰的静态内部类内存中有几份
 */
public class TestStaticInnerClass {

    AClass.BStaticInnerClass  ab = null;


    public static void main(String[] args) {
        /*TestStaticInnerClass  t1 = new TestStaticInnerClass();
        TestStaticInnerClass  t2 = new TestStaticInnerClass();
        if(t1.getAb() == null){
            t1.ab = new AClass.BStaticInnerClass();
        }
        if(t2.getAb() == null){
            t2.ab = new AClass.BStaticInnerClass();
        }
        System.out.println(t1.getAb());
        System.out.println(t2.getAb());*/
        AClass a1 = new AClass();
        AClass a2 = new AClass();
        System.out.println(1);

    }

    public AClass.BStaticInnerClass getAb() {
        return ab;
    }


}



