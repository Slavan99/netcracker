package com.myhashmap;

import javafx.util.Pair;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public interface MyMap<K,V> {
    int size();

    boolean isEmpty();

    boolean containsKey(K key);

    boolean containsValue(V value);

    void put(K key, V value);

    V get(K key);

    V remove(K key);

    Set keySet();

    Collection values();

    Set entrySet();
}
