package com.example.sort.shell;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hzq
 * @date 2019/6/25 12:57
 */
public class ShellSortTest {

    @Test
    public void test1(){
        int[] arr = {7,10,1,9,2,5,8,6,4,3};
        ShellSort shellSort = new ShellSort(arr);
        long begin = System.currentTimeMillis();
        shellSort.shellSort();
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr) + "耗时: " + (end - begin));
    }
}
