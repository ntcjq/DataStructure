package com.cui.hash;

import java.util.TreeMap;

/**
 * @Author: cuijq
 */
public class HashTable<K, V> {

    //长度（元素个数）
    private int size;
    //容量
    private int capacity;
    //初始默认容量
    private static final int initCapacity = 7;
    //resize上限
    private static final int MAX = 7;
    //resize下限
    private static final int MIN = 2;

    private TreeMap<K, V>[] table;

    public HashTable(int capacity){
        this.capacity = capacity;
        table = new TreeMap[capacity];
        for(int i = 0;i<capacity;i++){
            table[i] = new TreeMap<>();
        }

    }

    public HashTable(){
        this(initCapacity);
    }

    public int getSize(){
        return size;
    }

    /**
     * 获取key对应的hash值
     * @param key
     * @return
     */
    private int hash(K key){
        return Math.abs(key.hashCode())%capacity;
    }

    public void put(K key, V value){
        int hash = hash(key);
        TreeMap<K, V> treeMap = table[hash];
        if(!treeMap.containsKey(key)){
            treeMap.put(key,value);
            size++;
            if(size >= MAX*capacity){
                resize(2*capacity);
            }
        }else{
            treeMap.put(key,value);
        }
    }

    public V remove(K key){
        int hash = hash(key);
        TreeMap<K, V> treeMap = table[hash];
        V ret = null;
        if(treeMap.containsKey(key)){
            ret = treeMap.remove(key);
            size--;
            if(size < capacity/2 && capacity/2 >= initCapacity){
                resize(capacity/2);
            }
        }
        return ret;
    }


    public V get(K key){
        int hash = hash(key);
        TreeMap<K, V> treeMap = table[hash];
        return treeMap.get(key);
    }


    private void resize(int capacity){
        System.out.println("开始resize，原容量："+this.capacity+" 新容量："+capacity +" 当前size："+this.size);
        int oldCapacity = this.capacity;
        this.capacity = capacity;
        TreeMap<K, V>[] newHashTable = new TreeMap[capacity];
        for(int i = 0 ; i < capacity ; i ++){
            newHashTable[i] = new TreeMap<>();
        }
        for (int i = 0;i<oldCapacity;i++){
            TreeMap<K,V> treeMap = table[i];
            for(K k:treeMap.keySet()){
                newHashTable[hash(k)].put(k,treeMap.get(k));
            }
        }
        this.table = newHashTable;
    }
}
