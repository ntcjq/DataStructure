package com.cui.stack;

import com.cui.linkedlist.LinkedList;

/**
 * @Author: cuijq
 */
public class LinkedStack<E> implements Stack<E>{

    private LinkedList<E> linkedList;

    public LinkedStack(){
        linkedList = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {

        return linkedList.removeFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public E peek() {
        return linkedList.get(0);
    }


}
