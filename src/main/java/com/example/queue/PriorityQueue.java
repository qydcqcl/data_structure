package com.example.queue;

public class PriorityQueue {

    private int[] queArray;
    private int maxSize;
    private int length;

    /**
     * 基准点
     */
    private int referencePoint;

    public PriorityQueue(int maxSize, int referencePoint) {
        this.maxSize = maxSize;
        this.referencePoint = referencePoint;
        queArray = new int[maxSize];
        length = 0;
    }

    public void insert(int ele) throws Exception {
        if(isFull()){
            throw new Exception("队列已满!");
        }
        if(length == 0){
            queArray[length++] = ele;
        }else{
            int i;
            for(i = length; i > 0; i--){

                //待插入元素的距离
                int dis = Math.abs(ele - referencePoint);
                //当前元素的距离
                int curDis = Math.abs(queArray[i - 1] - referencePoint);

                //将比插入元素优先级高的元素后移一位
                if(dis >= curDis){
                    queArray[i] = queArray[i - 1];
                }
            }
            queArray[i] = ele;
            length++;
        }
    }

    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("队列已空");
        }
        return queArray[--length];
    }

    public int peek() throws Exception {
        if(isEmpty()){
            throw new Exception("队列已空");
        }
        return queArray[length - 1];
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
