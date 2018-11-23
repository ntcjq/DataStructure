package com.cui.stack;

/**
 * @Author: cuijq
 */
public class Main {

    public static void main(String[] args){
        ArrayStatck<Integer> statck = new ArrayStatck<>();
        for(int i = 0;i < 10;i++){
            statck.push(i);
            if(i%3 == 2){
                statck.pop();
            }
            System.out.println(statck.toString());
        }


    }
}
