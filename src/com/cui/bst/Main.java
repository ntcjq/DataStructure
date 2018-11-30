package com.cui.bst;

import java.util.TreeSet;

/**
 * @Author: cuijq
 */
public class Main {

    public static void main(String[] args){
        Bst<Integer> bst = new Bst<>();
        bst.add(10);
        bst.add(6);
        bst.add(14);
        bst.add(16);
        bst.add(15);
        bst.add(12);
        bst.add(2);
        bst.add(8);
        System.out.println(bst.toString());
//        bst.levelOrder();
//        System.out.println(bst.min());
//        System.out.println(bst.max());

        bst.removeMax();
        System.out.println(bst.toString());
        bst.removeMin();
        System.out.println(bst.toString());

        bst.remove(10);
        System.out.println(bst.toString());


        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(10);
        tree.add(12);
        tree.add(6);
        tree.add(11);
        System.out.println(tree);
        System.out.println(0x10);
    }
}
