package com.cui.queue;

import com.cui.array.Array;

/**
 * @Author: cuijq
 */
public class ArrayQueue<E> implements Queue<E>{

    private Array<E> array;

    private int size;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }
    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        array.add(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }
}
