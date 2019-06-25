package com.example.sort.insertion;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hzq
 * @date 2019/6/25 16:44
 */
public class InsertionSortTest {

    @Test
    public void test1(){
        int[] arr = {8,2,4,9,3,6};
        InsertionSort sort = new InsertionSort(arr);
        sort.test2();
        System.out.println(Arrays.toString(arr));
    }
}
