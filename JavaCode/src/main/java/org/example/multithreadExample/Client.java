package org.example.multithreadExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0 ; i <100 ; i++){
            executorService.execute(new NumberPrinter(i));
        }
    }
}
