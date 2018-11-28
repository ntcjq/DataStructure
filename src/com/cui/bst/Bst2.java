package com.cui.bst;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二分搜索树   没有重复元素
 * 优化新增
 * @Author: cuijq
 */
public class Bst2<E extends Comparable> {

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
        root = add(root,e);
    }
    private Node add(Node node,E e) {
        if(node == null){
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        }
        if(e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }


    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) <0){
            return contains(node.left,e);
        }else{
            return contains(node.right,e);
        }
    }


    /**
     * 前序遍历
     */
    public void preTraversal(){
        preTraversal(root);

    }
    private void preTraversal(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preTraversal(node.left);
        preTraversal(node.right);

    }

    /**
     * 中序遍历
     */
    public void midTraversal(){
        midTraversal(root);

    }
    private void midTraversal(Node node){
        if(node == null){
            return;
        }

        midTraversal(node.left);
        System.out.println(node.e);
        midTraversal(node.right);
    }
    /**
     * 后序遍历
     */
    public void sufTraversal(){
        sufTraversal(root);

    }
    private void sufTraversal(Node node){
        if(node == null){
            return;
        }
        sufTraversal(node.left);
        sufTraversal(node.right);
        System.out.println(node.e);

    }


    /**
     * 非递归实现前序遍历
     * 思路：用栈（Stack）的后进先出来实现，先把右节点压入栈，再把左节点压入栈
     * @return
     */
    public void preTraversalStack(){
        if(root == null ){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.e);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }


    /**
     *  层序遍历
     *  思路：利用队列（queue）的先进先出 ，先让左节点入队，再让右节点入队
     */
    public void levelOrder(){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.e);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
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
