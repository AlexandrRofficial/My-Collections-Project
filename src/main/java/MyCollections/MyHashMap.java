package MyCollections;

import java.util.Objects;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private int size;
    private Entry<K, V>[] buckets;

    private static class Entry <K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        buckets = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }

    private int getIndex(K key) {
        if (key == null) {
            return 0;
        }

        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(K key, V value) {
        int bucketNumber = getIndex(key);
        Entry<K, V> currentBucket = buckets[bucketNumber];

        while (currentBucket != null) {
            if (Objects.equals(currentBucket.key, key)) {
                currentBucket.value = value;
                return;
            }

            currentBucket = currentBucket.next;
        }

        Entry<K, V> entry = new Entry<>(key, value, null);
        buckets[bucketNumber] = entry;
        size++;
    }

    public V remove(K key) {
        int bucketNumber = getIndex(key);
        Entry<K, V> currentBucket = buckets[bucketNumber];
        Entry<K, V> previousBucket = null;

        while (currentBucket != null) {
            if (Objects.equals(currentBucket.key, key)) {
                if (previousBucket == null) {
                    buckets[bucketNumber] = currentBucket.next;
                } else {
                    previousBucket.next = currentBucket.next;
                }

                size--;
                return currentBucket.value;
            }

            previousBucket = currentBucket;
            currentBucket = currentBucket.next;
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        buckets = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int bucketNumber = getIndex(key);
        Entry<K, V> currentBucket = buckets[bucketNumber];

        while (currentBucket != null) {
            if (Objects.equals(currentBucket.key, key)) {
                return currentBucket.value;
            }

            currentBucket = currentBucket.next;
        }

        return null;
    }
}
