package com.cui.array;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Array<Integer> arr = new Array<>();
        for(int i = 0;i < 10;i++){
            arr.add(i);
            if(i%3 == 2){
                arr.removeFirst();
            }
            System.out.println(arr.toString());
        }


    }
}
