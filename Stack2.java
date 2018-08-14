/**

Implement a stack that returns the maximum element, all pop and push operations to should
consider updating the maximum value stored in the stack.

*/

package com.codrite;


import java.util.*;

class Pair implements Comparable<Pair> {

    Integer k;
    Integer occ;

    Pair(Integer value, Integer occurence){
        this.k = value;
        this.occ = occurence;
    }

    private Integer getK(){
        return this.k;
    }

    Integer getOcc(){
        return this.occ;
    }

    boolean decrement(){
        if(this.occ > 0) {
            this.occ--;
            return true;
        }

        return false;
    }

    void increment(){
        this.occ++;
    }

    public int compareTo(Pair other){
        return k.compareTo(other.getK());
    }

}

class Stack2 {

    private Stack<Integer> stackA;
    private Stack<Pair> stackB;

    private Stack2() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    private void push(Integer k){
        stackA.push(k);

        if(stackB.size() == 0 || stackB.peek().k.compareTo(k) < 0)
            stackB.push(new Pair(k, 1));
        else {
            if(stackB.peek().k.compareTo(k) == 0) {
                Pair element = stackB.pop();
                element.increment();
                stackB.push(element);
            }
        }
    }

    private Integer pop(){
        if(stackA.empty())
            return -2;

        if(stackB.peek().k.compareTo(stackA.peek()) == 0) {
            Pair element = stackB.pop();
            if(element.decrement() && element.getOcc() > 0)
                stackB.push(element);
        }

        return stackA.pop();
    }

    private Integer getMax() {
        if(stackB.isEmpty())
            return -1;

        return stackB.peek().k;
    }

    public static void main(String[] args){
        Stack2 s = new Stack2();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        System.out.println(s.getMax());
        System.out.println(s.pop());
        System.out.println(s.getMax());
        System.out.println(s.pop());
        System.out.println(s.getMax());
        System.out.println(s.pop());
        System.out.println(s.getMax());
        System.out.println(s.pop());
        System.out.println(s.getMax());
        System.out.println(s.pop());
        System.out.println(s.getMax());
        System.out.println(s.pop());
        System.out.println(s.getMax());
        System.out.println(s.pop());
        System.out.println(s.getMax());
        System.out.println(s.pop());
        System.out.println(s.getMax());
        System.out.println(s.pop());
        System.out.println(s.getMax());
        System.out.println(s.pop());
        System.out.println(s.getMax());
        System.out.println(s.pop());
        System.out.println(s.getMax());
    }

}