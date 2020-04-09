package com.myhashmap;

import java.util.*;

public class MyHashMap<K, V> implements MyMap<K,V> {
    private int size = 0;

    private static final int INIT_CAPACITY = 16;

    private Entry<K,V>[] array;

    public MyHashMap(){
        this(INIT_CAPACITY);
    }

    public MyHashMap(int capacity){
        this.array = new Entry[capacity];
    }


    public static class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return key.equals(entry.key) &&
                    value.equals(entry.value);
        }

        @Override
        public int hashCode() {
            int p = 29989;
            int q = 29983;
            return key.hashCode() + value.hashCode();
        }

        @Override
        public String toString() {
            return '{' +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(K key) {
        return keySet().contains(key);
    }

    @Override
    public boolean containsValue(V value) {
        return values().contains(value);
    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = array[key.hashCode() % array.length];
        while(entry != null){
            if(entry.key.equals(key))
                return entry.value;
            entry = entry.next;
        }
        return null;
    }

    void resize(){
        Entry<K,V>[] newArray = new Entry[size * 2];
        System.arraycopy(array,0, newArray,0,size);
        array = newArray;
    }


    @Override
    public void put(K key, V value) {

        if(size == array.length)
            resize();

        Entry<K,V> entry = new Entry<>(key,value,null);

        int index = key.hashCode() % array.length;

        Entry<K,V> existEntry = array[index];
        if(existEntry == null){
            array[index] = entry;
            size++;
        }
        else{
            while(existEntry.next != null){
                if(existEntry.key.equals(key)){
                    existEntry.value = value;
                    return;
                }
                existEntry = existEntry.next;
            }
            if (existEntry.key.equals(key)) {
                existEntry.value = value;
            } else {
                existEntry.next = entry;
                size++;
            }
        }
    }

    @Override
    public V remove(K key) {
        Entry<K, V> entry = array[key.hashCode() % array.length];
        while(entry != null){
            if(entry.key.equals(key))
                if(entry.next != null) {
                    V val = entry.value;
                    entry.next = entry;
                    return val;
                }
                else{
                    V val = entry.value;
                    array[key.hashCode() % array.length] = null;
                    return val;
                }
            entry = entry.next;
        }
        return null;
    }


    @Override
    public Set<K> keySet() {
        Set<Entry<K, V>> entries = entrySet();
        Set<K> keySet = new HashSet<>();
        for (Entry<K,V> entry: entries) {
            keySet.add(entry.key);
        }
        return keySet;
    }

    @Override
    public Collection<V> values() {
        Set<Entry<K, V>> entries = entrySet();
        Collection<V> values = new ArrayList<>();
        for (Entry<K,V> entry: entries) {
            values.add(entry.value);
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                entries.add(array[i]);
                while (array[i].next != null) {
                    entries.add(array[i].next);
                    array[i] = array[i].next;
                }
            }
        }
        return entries;
    }

    @Override
    public String toString() {
        return entrySet().toString();
    }
}
