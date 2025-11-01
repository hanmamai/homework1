package main.java;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private Object[] table;
    private int size;

    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        this.table = new Object[DEFAULT_CAPACITY];
    }

    private int hash(K key) {
        if (key == null) return 0;
        return key.hashCode();
    }

    private int indexFor(int hash, int length) {
        return Math.abs(hash % length);
    }


    public V put(K key, V value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        Entry<K, V> first = (Entry<K, V>) table[index];


        for (Entry<K, V> e = first; e != null; e = e.next) {
            if ((key == null && e.key == null) ||
                    (key != null && key.equals(e.key))) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }


        Entry<K, V> newEntry = new Entry<>(key, value, first);
        table[index] = newEntry;
        size++;

        return null;
    }


    public V get(K key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        Entry<K, V> e = (Entry<K, V>) table[index];
        while (e != null) {
            if ((key == null && e.key == null) ||
                    (key != null && key.equals(e.key))) {
                return e.value;
            }
            e = e.next;
        }
        return null;
    }


    public V remove(K key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        Entry<K, V> prev = null;
        Entry<K, V> e = (Entry<K, V>) table[index];

        while (e != null) {
            if ((key == null && e.key == null) ||
                    (key != null && key.equals(e.key))) {
                V oldValue = e.value;
                if (prev == null) {
                    table[index] = e.next;
                } else {
                    prev.next = e.next;
                }
                size--;
                return oldValue;
            }
            prev = e;
            e = e.next;
        }
        return null;
    }

    public int size() {
        return size;
    }
}