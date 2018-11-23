package com.cui.linkedlist;

/**
 * @Author: cuijq
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

//        @Override
//        public String toString() {
//            return e.toString();
//        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }


    public void add(int index,E e){
        if(index < 0 || index > size ){
            throw new IllegalArgumentException("index < 0 || index > size");
        }
        Node pre = dummyHead;
        for(int i = 0;i<index;i++){
            pre = pre.next;
        }
//        Node node  = new Node(e);
//        node.next = pre.next;
//        pre.next = node;
        //上面三行简写成一行
        pre.next = new Node(e,pre.next);
        size++;
    }

    public void addFirst(E e){
        add(0,e);
    }
    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        if(index < 0 || index > size -1 ){
            throw new IllegalArgumentException("index < 0 || index > size");
        }
        Node pre = dummyHead;
        for(int i = 0;i<=index;i++){
            pre = pre.next;
        }
        return pre.e;
    }

    public void set(int index,E e){
        if(index < 0 || index > size -1 ){
            throw new IllegalArgumentException("index < 0 || index > size");
        }
        Node cur = dummyHead.next;
        for(int i = 0;i<index;i++){
            cur = cur.next;
        }
        cur.e  =e;
    }

    public E remove(int index){
        Node pre = dummyHead;
        for(int i = 0;i<index;i++){
            pre = pre.next;
        }
        E ret = pre.next.e;
        pre.next = pre.next.next;
        size--;
        return ret;
    }


    public E removeFirst() {
        return remove(0);
    }

    public E removeLast(){
        return remove(size -1);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("LinkedList size：" + size + "\n[");
//        Node pre = dummyHead;
//        while(pre.next != null){
//            pre = pre.next;
//            sb.append(pre.e+",");
//        }
        for(Node pre = dummyHead;pre.next != null;pre = pre.next){
            sb.append(pre.next.e+",");
        }
        sb.append("] ->");
        return sb.toString();
    }

    public Node removeElements(Node head, E val) {
        Node dummyHead = new Node();
        dummyHead.next = head;

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e == val)
            {
                prev.next = prev.next.next;
            } else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public Node getHead(){
        return dummyHead.next;
    }
}
