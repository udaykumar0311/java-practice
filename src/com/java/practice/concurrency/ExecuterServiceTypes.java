package com.java.practice.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterServiceTypes {
    public static void main(String[] args){
        //CachedThread Pool
        ExecutorService es1 = Executors.newCachedThreadPool();

        //SingleThread pool
        ExecutorService es2 = Executors.newSingleThreadExecutor();

        int count = Runtime.getRuntime().availableProcessors();
        System.out.println("No of available processors for execution: "+count);
        //FixedThread Pool
        ExecutorService es3 = Executors.newFixedThreadPool(count+10);

    }
}
