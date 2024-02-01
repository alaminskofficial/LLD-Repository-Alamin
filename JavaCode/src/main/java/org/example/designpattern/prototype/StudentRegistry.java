package org.example.designpattern.prototype;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    private Map<String , Student> hm = new HashMap<>();
    public void register(String key , Student st){
        hm.put(key , st);
    }
    public Student get(String key){
        if(hm.containsKey(key)){
            return  hm.get(key);
        }return null;
    }
}
