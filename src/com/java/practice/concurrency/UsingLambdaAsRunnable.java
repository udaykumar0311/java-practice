package com.java.practice.concurrency;

public class UsingLambdaAsRunnable {
    public static void main(String[] args){
        Thread thread = new Thread(() -> {
            System.out.println("run(): "+Thread.currentThread().getName());
        });
        thread.start();
//        thread.run();
        System.out.println("main(): "+Thread.currentThread().getName());
    }
}
