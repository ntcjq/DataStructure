package com.cui.bst;

/**
 * 二分搜索树   没有重复元素
 * @Author: cuijq
 */
public class Bst<E extends Comparable> {

    private class Node{
        public E e;
        public Node left;
        public Node right;
        Node(){
        }
        Node(E e){
            this.e = e;
        }
    }

    private Node root;
    private int size;


    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Node getRoot(){
        return root;
    }

    public void add(E e){
        if(root == null){
            root = new Node(e);
        }else{
            add(root,e);
        }
    }
    private void add(Node node,E e) {
        if (node.e.compareTo(e) == 0) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            return;
        }

        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     */
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++){
            res.append("--");
        }
        return res.toString();
    }
}
