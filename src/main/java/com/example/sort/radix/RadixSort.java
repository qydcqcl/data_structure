package com.example.sort.radix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hzq
 * @date 2019/6/25 20:29
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {135,242,192,93,345,11,24,19};
        long begin = System.currentTimeMillis();
        radixSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr) + " 耗时: " + (end - begin));
    }

    public static void radixSort(int[] arr){
        int max = arr[0];

        //找到数组中的最大值
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        //关键字的个数，我们使用个位、十位、百位...当做关键字，所以关键字的个数就是最大值的位数
        int keysNum = 0;
        while(max > 0){
            max = max / 10;
            keysNum++;
        }

        List<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
        //每位可能的数字为0~9，所以设置10个桶
        for(int i = 0; i < 10; i++){
            //桶由ArrayList<Integer>构成
            buckets.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < keysNum; i++){
            //由最次关键字开始，依次按照关键字进行分配
            for(int j = 0; j < arr.length; j++){
                //扫描所有数组元素，将元素分配到对应的桶中
                //取出该元素对应第i+1位上的数字，比如258，现在要取出十位上的数字，258%100=58,58/10=5
                int key =arr[j] % (int) Math.pow(10, i+1) / (int) Math.pow(10, i);
                //将该元素放入关键字为key的桶中
                buckets.get(key).add(arr[j]);
            }

            //分配完之后，将桶中的元素依次复制回数组
            //元素计数器
            int counter = 0;
            for(int j = 0; j < 10; j++){
                //关键字为j的桶
                ArrayList<Integer> bucket = buckets.get(j);
                while(bucket.size() > 0){
                    //将桶中的第一个元素复制到数组，并移除
                    arr[counter++] = bucket.remove(0);
                }
            }
            System.out.println("第" + (i+1) + "轮排序: " + Arrays.toString(arr));
        }
    }
}
