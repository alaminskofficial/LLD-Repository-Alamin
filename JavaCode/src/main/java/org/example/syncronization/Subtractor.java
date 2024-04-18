package org.example.syncronization;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{
    Count Count;
    Lock lock;
    public Subtractor(Count Count, Lock lock) {
        this.Count = Count;
        this.lock = lock;
    }
    @Override
    public void run() {
        for(int i = 1 ; i <= 1000000; i++){
            lock.lock();
            Count.value -= i;
            lock.unlock();
        }
    }
}
