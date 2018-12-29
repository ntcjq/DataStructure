package com.cui.hash;

import java.util.Random;

/**
 * @Author: cuijq
 */
public class Main {

    public static void main(String[] args){

        HashTable<String,String> hashTable = new HashTable<>();
        Random random = new Random();
        int[] arr = new int[10000];
        for(int i = 0;i<arr.length;i++){
            arr[i] = random.nextInt(100000);
        }
        for(int i = 0;i<arr.length;i++){
            int randInt = arr[i];
            hashTable.put("cjq"+randInt,"cjq"+randInt+"_value");
        }
        for(int i = 0;i<arr.length-1;i++){
            int randInt = arr[i];
            hashTable.remove("cjq"+randInt);
        }
        System.out.println(hashTable.get("cjq"+arr[arr.length-1]));
    }



}
