package com.myhashmap;

public class Test {
    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 16; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < i; j++) {
                stringBuilder.append("s");
            }
            myHashMap.put(i,stringBuilder.toString());
        }
        myHashMap.put(16,"aa");
        System.out.println(myHashMap);
        System.out.println(myHashMap.size());

    }
}
