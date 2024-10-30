package com.demo.basic.obj;

public class Animal {

    public String name = "animal";

    public void  eat(){
        System.out.println("开吃");
    }

    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat(); //吃肉
        System.out.println(animal); //animal
    }

}
