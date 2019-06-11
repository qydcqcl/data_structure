package com.example.array;

import org.junit.Test;

public class ArrayTest {

    @Test
    public void test1(){
        Array arr = new Array(5);
        arr.insert("aa");
        arr.insert("bb");
        arr.insert("cc");
        arr.insert("dd");
        arr.insert("ee");

        arr.display();
    }

}
