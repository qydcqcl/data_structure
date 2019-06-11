package com.example.queue;

public class Queue {

    private int[] queArray;
    private int maxSize;

    /**
     * 队头元素的下标
     */
    private int front;


    /**
     * 队尾元素的下标
     */
    private int rear;
    private int length;

    public Queue(int maxSize) {
        front = 0;
        rear = -1;
        length = 0;
        queArray = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void insert(int ele) throws Exception {
        if(isFull()){
            throw new Exception("队列已满!");
        }
        //如果队尾指针已到达数组的末端，插入到数组的第一个位置
        if(rear == maxSize - 1){
            rear = -1;
        }
        queArray[++rear] = ele;
        length++;
    }

    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("队列已空!");
        }
        int ele = queArray[front++];
        //如果队头指针已到达数组末端，则移到数组第一个位置
        if(front == maxSize - 1){
            front = 0;
        }
        length--;
        return ele;
    }

    public int peek(){
        if(isEmpty()){
            throw new NullPointerException();
        }
        return queArray[front];
    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public boolean isFull(){
        return length == maxSize;
    }
}
