package com.cui.queue;

import com.cui.stack.ArrayStatck;

/**
 * @Author: cuijq
 */
public class Main {

    public static void main(String[] args){

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0;i < 10;i++){
            queue.enqueue(i);
            if(i%3 == 2){
                queue.dequeue();
            }
            System.out.println(queue.toString());
        }
    }
}
