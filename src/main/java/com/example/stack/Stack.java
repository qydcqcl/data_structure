package com.example.stack;

public class Stack {

    private int size;
    private int top;
    private int[] stackArray;

    public Stack(int size) {
        top = -1;
        stackArray = new int[size];
        this.size = size;
    }

    public void push(int ele){
        stackArray[++top] = ele;
    }

    public int pop(){
        return stackArray[top--];
    }

    public int peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size - 1;
    }
}
