package org.example.semaphoreDemo;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    private Queue<Shirt> shops;
    private String name;
    Semaphore semaProducer;
    Semaphore semaConsumer;

    public Consumer(Queue<Shirt> store, String name, Semaphore semaProducer, Semaphore semaConsumer) {
        this.shops = store;
        this.name = name;
        this.semaProducer = semaProducer;
        this.semaConsumer = semaConsumer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                semaConsumer.acquire();
                System.out.println("Current Size - " + shops.size() + " Removed by consumer - " + name);
                shops.remove();
                semaProducer.release();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
