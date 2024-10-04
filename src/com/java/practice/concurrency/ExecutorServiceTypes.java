package com.java.practice.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTypes {
    public static void main(String[] args){
        //CachedThreadPool
        ExecutorService es = Executors.newCachedThreadPool();
        es.close();
        //FixedThreadPool
        int cpuCount = Runtime.getRuntime().availableProcessors();
        System.out.println("cpuCount: "+ cpuCount);
        ExecutorService es2 = Executors.newFixedThreadPool(cpuCount);
        es2.close();
        //SingleThreadPool
        ExecutorService es3 = Executors.newSingleThreadExecutor();
        es3.close();
    }
}
