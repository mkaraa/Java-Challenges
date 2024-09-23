package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    // Constructor
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);  // true: accessOrder mode
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        // Adding elements to the cache
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        // Accessing elements
        System.out.println("Get 1: " + cache.get(1));  // Access element 1

        // Adding another element, this should evict the least recently used element (key 2)
        cache.put(4, "Four");

        // Checking the contents of the cache
        System.out.println("Cache contents after adding key 4:");
        cache.forEach((k, v) -> System.out.println(k + ": " + v));  // Should not contain key 2
    }

    // Override removeEldestEntry to remove the least recently used entry
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    // Get an entry
    public V get(Object key) {
        return super.getOrDefault(key, null);
    }

    // Put an entry
    public V put(K key, V value) {
        super.put(key, value);
        return value;
    }
}




