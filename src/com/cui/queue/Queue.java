package com.cui.queue;

/**
 * @Author: cuijq
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
