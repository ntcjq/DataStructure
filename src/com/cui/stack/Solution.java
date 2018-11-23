package com.cui.stack;

import java.util.Stack;

/**
 * @Author: cuijq
 */
public class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }
            if(c==')' || c=='}' || c==']'){
                if(stack.isEmpty()){
                    return false;
                }
                char temp = stack.pop();
                if(c==')' && temp!='('){
                    return false;
                }
                if(c=='}' && temp!='{'){
                    return false;
                }
                if(c==']' && temp=='['){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args){

        Solution solution = new Solution();
        int[] arr = {1,2,3,4,5,6};

        int[] res = solution.shuffle(arr);
        for(int i =0;i<res.length;i++){
            System.out.print(res[i]);
        }
    }
    public int[] shuffle(int[] nums) {

        int[] rand = nums.clone();
        for (int i = 0; i < rand.length; i++){
            int r = (int) (Math.random() * (rand.length));
            int temp = rand[r];
            rand[r] =  rand[i];
            rand[i] = temp;
        }
        return rand;
    }


}

