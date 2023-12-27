package com.demo.test.offer.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author :xiezhi
 * @date : 2023/10/31
 */
public class Jol {

    public static void main(String[] args) {
        Object o = new Object();
        String printable = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(printable);
    }
}
