package com.example.demo;

public class Task1 {
    @FunctionalInterface
    interface MyInterface {
        void sayHello();
    }

    public static void run() {
        MyInterface greeting = () -> System.out.println("Cześć z lambdy!");
        greeting.sayHello();
    }
}

