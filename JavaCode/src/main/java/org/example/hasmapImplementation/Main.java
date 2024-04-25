package org.example.hasmapImplementation;

public class Main {
    public static void main(String[] args) {
        CustomHashMap<String , Integer> customHashMap = new CustomHashMap<>();
        customHashMap.put("A", 1);
        customHashMap.put("B", 2);
        customHashMap.put("C", 3);
        customHashMap.put("D", 4);
        customHashMap.put("E", 5);
        System.out.println(customHashMap.get("A"));
        System.out.println(customHashMap.size());
        customHashMap.remove("A");
        System.out.println(customHashMap.size());
    }
}
