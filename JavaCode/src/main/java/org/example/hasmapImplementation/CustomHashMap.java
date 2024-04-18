package org.example.hasmapImplementation;

import java.util.LinkedList;

/**
 * CustomHashMap is a class that implements a basic HashMap data structure.
 * It uses generics K and V to allow for flexibility in key and value types.
 * The HashMap uses LinkedLists for handling collisions.
 */
public class CustomHashMap<K , V> {
    // Default size for the HashMap
    private static final int DEFAULT_SIZE = 16;
    // Default load factor for the HashMap
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    // Size of the HashMap
    private int size;
    // Array of LinkedLists to store the key-value pairs
    private LinkedList<Pair<K,V>> [] buckets;

    /**
     * Default constructor for the CustomHashMap class.
     * Initializes the buckets array with the default size.
     */
    public CustomHashMap() {
        this.buckets = new LinkedList[DEFAULT_SIZE];
        for(int i = 0; i < DEFAULT_SIZE; i++){
            this.buckets[i] = new LinkedList<>();
        }
    }

    /**
     * Constructor for the CustomHashMap class that takes a capacity argument.
     * Initializes the buckets array with the given capacity.
     * @param capacity The initial capacity of the HashMap.
     */
    public CustomHashMap(int capacity) {
        this.buckets = new LinkedList[capacity];
        for(int i = 0; i < capacity; i++){
            this.buckets[i] = new LinkedList<>();
        }
    }
    private int bucketIndex(K key){
        return key.hashCode() % buckets.length;
    }
    public void put(K key  , V value){
        int bucketIndex = bucketIndex(key);
        LinkedList<Pair<K,V>> bucket = buckets[bucketIndex];
        for(Pair<K,V> pair : bucket){
            if(pair.key.equals(key)){
                pair.value = value;
                return;
            }
        }
        bucket.add(new Pair<>(key,value));
        size++;
        if((1.0*size)/buckets.length > DEFAULT_LOAD_FACTOR){
            rehash();
        }
    }
    public V get(K key){
        int bucketIndex = bucketIndex(key);
        LinkedList<Pair<K,V>> bucket = buckets[bucketIndex];
        for(Pair<K,V> pair : bucket){
            if(pair.key.equals(key)){
                return pair.value;
            }
        }
        return null;
    }
    public V remove(K key){
        int bucketIndex = bucketIndex(key);
        LinkedList<Pair<K,V>> bucket = buckets[bucketIndex];
        Pair<K,V> toRemove = null;
        for(Pair<K,V> pair : bucket){
            if(pair.key.equals(key)){
                toRemove = pair;
                break;
            }
        }
        if(toRemove != null){
            bucket.remove(toRemove);
            size--;
            return toRemove.value;
        }
        return null;
    }
    public int size(){
        return size;
    }
    private void rehash(){
        LinkedList<Pair<K,V>> [] temp = buckets;
        buckets = new LinkedList[2*temp.length];
        for(int i = 0; i < 2*temp.length; i++){
            buckets[i] = new LinkedList<>();
        }
        for(LinkedList<Pair<K,V>> bucket : temp){
            for(Pair<K,V> pair : bucket){
                put(pair.key,pair.value);
            }
        }
    }
}