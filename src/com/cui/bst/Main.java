package com.cui.bst;

/**
 * @Author: cuijq
 */
public class Main {

    public static void main(String[] args){
        Bst2<Integer> bst = new Bst2<>();
        bst.add(10);
        bst.add(6);
        bst.add(14);
        bst.add(16);
        bst.add(15);
        bst.add(12);
        bst.add(2);
        bst.add(8);
        bst.printTree();
        bst.removeMax();
        bst.removeMin();
    }
}
