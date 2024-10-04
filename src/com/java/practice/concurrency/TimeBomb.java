package com.java.practice.concurrency;

public class TimeBomb {
    public static void main(String[] args){
        Thread t = new Thread(new CountDown());
        System.out.println("Starting 5 seconds count down");
        try {
            t.start();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Boom!!!!!");

    }

}

//sleep() and join()
class CountDown implements Runnable{
    String [] timeStr = { "Zero","One","Two","Three","Four","Five"};
    @Override
    public void run() {
        for (int i=5; i>=0; i--){
            try {
                System.out.println(timeStr[i]);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}