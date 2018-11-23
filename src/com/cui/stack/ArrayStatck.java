package com.cui.stack;

import com.cui.array.Array;

/**
 * @Author: cuijq
 */
public class ArrayStatck<E> implements Stack<E>{

    private Array<E> data;

    public ArrayStatck(){
        data  = new Array<>();
    }


    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.get(data.getSize()-1);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("ArrayStack size:%d\n",getSize()));
        sb.append("[");
        for(int i = 0;i<getSize();i++){
            sb.append(data.get(i));
            if(i != (getSize()-1)){
                sb.append(",");
            }
        }
        sb.append("] Top");
        return sb.toString();
    }
}
