package com.example.sort.quik;

import org.junit.Test;

/**
 * @author hzq
 * @date 2019/6/24 20:37
 */
public class QickSortTest {

    @Test
    public void test(){
        int[] arr = {57,68,59,52,72,28,96,33,24,19};
        QuikSort sort = new QuikSort(arr);
        sort.quikSort();
    }
}
