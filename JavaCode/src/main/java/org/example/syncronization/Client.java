package org.example.syncronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) {
        Count count = new Count();
        Lock lock = new ReentrantLock();
        Thread thread1 = new Thread(new Adder(count , lock));
        Thread thread2 = new Thread(new Subtractor(count , lock));
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            System.out.println("Count: " + count.value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
