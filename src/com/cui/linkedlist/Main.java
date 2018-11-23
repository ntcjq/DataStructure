package com.cui.linkedlist;

/**
 * @Author: cuijq
 */
public class Main {


    public static void main(String[] args){

        LinkedList<Integer> linkedList =  new LinkedList<>();
//        for(int i = 0;i<5;i++){
//            linkedList.addFirst(i);
//            System.out.println(linkedList.toString());
//        }
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(2);
        linkedList.addFirst(5);
        System.out.println(linkedList.toString());
        linkedList.set(2,666);
        System.out.println(linkedList.toString());


        System.out.println(linkedList.removeElements(linkedList.getHead(),4));
    }
}
