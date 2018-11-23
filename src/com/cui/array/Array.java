package com.cui.array;

/**
 * @Author: cuijq
 */
public class Array<E> {

    private E[] data;
    private int size;


    public Array(int capacity){
        data = (E[])new Object[capacity];
    }

    public Array(){
        this(10);
    }

    public int getCapacity(){
        return data.length;
    }
    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Array size:%d capacity:%d\n",getSize(),getCapacity()));
        sb.append("[");
        for(int i = 0;i<size;i++){
            sb.append(data[i]);
            if(i != (size-1)){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void add(E e){
        add(size,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }

    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("illegal index");
        }
        if(size == data.length ){
            resize(2*data.length);
        }

        for(int i = size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }


    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("illegal index");
        }
        return data[index];
    }

    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("illegal index");
        }
        E res = data[index];
        for(int i = index;i < size-1;i++){
            data[i] = data[i+1];
        }
        size--;
        data[size] = null;
        if(size == data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }
        return res;
    }

    public E removeLast(){
        return remove(size-1);
    }
    public E removeFirst(){
        return remove(0);
    }

    private void resize(int capacity){
        E[] newData = (E[])new Object[capacity];
        for(int i=0;i<size;i++){
            newData[i] = (data[i]);
        }
        this.data = newData;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
