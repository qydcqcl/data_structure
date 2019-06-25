package com.example.sort.merge;

import org.junit.Test;

/**
 * @author hzq
 * @date 2019/6/24 20:11
 */
public class MergeSortTest {

    @Test
    public void test(){
        int [] a ={6,2,7,4,8,1,5,3};
        MergeSort sort = new MergeSort(a);
        sort.mergeSort();
    }
}
