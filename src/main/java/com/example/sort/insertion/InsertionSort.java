package com.example.sort.insertion;

import java.util.Arrays;

/**
 * @author hzq
 * @date 2019/6/24 11:37
 * @desc 在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排好顺序的，现在要把第n个数找到相应位置并插入，使得这n个数也是排好顺序的。
 * 如此反复循环，直到全部排好顺序。
 */
public class InsertionSort {

    private int[] arr;

    public InsertionSort(int[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
        int[] arr = {8,2,4,9,3,6};
        test1(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void test1(int[] arr){
        int len = arr.length;
        int counter = 1;
        for(int i = 1; i < len ; i++){
            //待排序的数
            int temp = arr[i];
            //与待排序元素值坐比较的元素的下标
            int insertPoint = i - 1;
            while(insertPoint >= 0 && arr[insertPoint] > temp){
                //当前元素比待排序元素大
                //当前元素后移一位
                arr[insertPoint+1] = arr[insertPoint];
                insertPoint--;
            }
            //找到了插入位置，插入待排序元素
            arr[insertPoint + 1] = temp;
            System.out.println("第" + (counter++) + "轮排序结果:" + Arrays.toString(arr));
        }
    }

    /**
     * 在插入某个元素之前需要先确定该元素在有序数组中的位置，上例的做法是对有序数组中的元素逐个扫描，
     * 当数据量比较大的时候，这是一个很耗时间的过程，可以采用二分查找法改进，这种排序也被称为二分插入排序。
     */
    public void test2(){
        int len = arr.length;
        for(int i = 1; i < len; i++){
            //存储待排序的元素值
            int temp = arr[i];
            if(arr[i-1] > temp){
                //比有序数组的最后一个元素要小
                //使用二分查找获取应插入位置的下标
                int insertIndex = binarySearch(0, i-1, temp);
                //将有序数组中插入点之后的元素后移一位
                for(int j = i; j > insertIndex; j--){
                    arr[j] = arr[j-1];
                }
                arr[insertIndex] = temp;
            }
        }
    }

    private int binarySearch(int lowerBound, int upperBound, int target) {
        int curIndex;
        while(lowerBound <= upperBound){
            curIndex= (lowerBound+upperBound)/2;
            if(arr[curIndex]>target){
                upperBound= curIndex - 1;
            }else{
                lowerBound= curIndex + 1;
            }
        }
        return lowerBound;
    }
}
