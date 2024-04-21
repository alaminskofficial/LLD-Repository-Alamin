package org.example.semaphoreDemo;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer  implements Runnable{
    private Queue<Shirt> shops;
    private int maxSize;
    private String name;
    Semaphore semaProducer;
    Semaphore semaConsumer;
    public Producer(Queue<Shirt> shops, String name, int maxSize, Semaphore semaProducer, Semaphore semaConsumer) {
        this.shops = shops;
        this.maxSize = maxSize;
        this.name = name;
        this.semaProducer = semaProducer;
        this.semaConsumer = semaConsumer;
    }

    @Override
    public void run() {
        while(true){
            try{
                semaProducer.acquire();
                System.out.println("Current Size - " + shops.size() + " Added by producer - " + name);
                shops.add(new Shirt());
                semaConsumer.release();

            }catch (Exception e){
                e.getMessage();
            }
        }
    }
}
