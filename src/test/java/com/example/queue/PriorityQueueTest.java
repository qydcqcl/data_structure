package com.example.queue;

import org.junit.Test;

public class PriorityQueueTest {

    @Test
    public void test1(){
        try {
            PriorityQueue priorityQueue = new PriorityQueue(5,3);
            priorityQueue.insert(1);
            priorityQueue.insert(5);
            priorityQueue.insert(2);
            priorityQueue.peek();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
