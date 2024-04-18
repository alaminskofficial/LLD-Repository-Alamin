package org.example.hashMapThreadsafetyChck;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Client {
    public static void main(String[] args) {
        Map<String ,Integer> map = new HashMap<>();
        Thread t1 = new Thread(() ->{
            for(int i = 0 ; i < 1000 ; i++){
                map.put("Key->" + i, i);
            }
        });
        Thread t2 = new Thread(() ->{
            for(int i = 0 ; i < 1000 ; i++){
                map.put("Key->" + i+1000, i+1000);
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Map size: " + map.size());
    }
}
