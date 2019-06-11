package com.example.array;

import org.junit.Test;

public class OrderArrayTest {

    @Test
    public void test1(){
        OrderArray arr = new OrderArray(20);
//        for(int i = 0; i < 20; i++){
//            arr.insert(i);
//        }
//        arr.insert(0);
        arr.insert(1);
        int i = arr.find(0);
        System.out.println(i);
    }
}
