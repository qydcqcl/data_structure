package com.example.sort.bubble;

import java.util.Arrays;

/**
 * @author hzq
 * @date 2019/6/22 12:59
 */
public class BubbleSort {

    /**
     * 对当前还未排好序的范围内的全部数，自上而下对相邻的俩个数依次进行比较和调整，让较大的数下沉，较小的数往上冒。
     * 即：每当俩相邻的数比较后发现他们的排序与排序的要求相反时，就将他们交换。
     * 每次遍历都可确定一个最大值放到待排数组的末尾，下次遍历，对该最大值以及它之后的元素不再排序（已经排好）。
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {3,6,4,2,11,10,5};
        test1(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 每次比较相邻两个数的大小，大数后移，每次遍历可确定一个最大值
     * @param arr
     */
    public static void test1(int[] arr){
        int temp;
        int counter = 1;
        for(int i = 0; i < arr.length - 1; i++){
            //外层循环：每循环一次就确定了一个相对最大元素
            for(int j = 0; j < arr.length - i -1; j++){
                //内层循环：有i个元素已经排好，根据i确定本次的比较次数
                if(arr[j] > arr[j + 1]){
                    //如果前一位大于后一位，交换位置
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第" + (counter++ )+ "轮结果: " + Arrays.toString(arr));
        }
    }

    /**
     * 加入标志性变量exchange，用于标志某一趟排序过程中是否有数据交换，如果进行某一趟排序时并没有进行数据交换，则说明数据已经按要求排列好，
     * 可立即结束排序，避免不必要的比较过程
     * @param arr
     */
    public static void test2(int[] arr){
        int len = arr.length;
        int temp;
        for (int i = 0; i < len; i++){
            boolean exchange = false;
            for(int j = 1; j < len - i; j++){
                if(arr[j - 1] > arr[j]){
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    if (!exchange) {
                        exchange = true;
                    }
                }
            }
            System.out.println("第" + (i+1) + "轮结果:" + Arrays.toString(arr));
            if(!exchange){
                break;
            }
        }
    }

    /**
     * 设置一个pos指针，pos后面的数据在上一轮排序中没有发生交换，下一轮排序时，就对pos之后的数据不再比较。
     * @param arr
     */
    public static void test3(int[] arr){
        int temp;
        int counter = 1;
        //代表最后一个需要比较的元素下标
        int endPoint = arr.length - 1;

        while(endPoint > 0){
            int pos = 1;
            for(int j = 1; j <= endPoint; j++){
                //如果前一位大于后一位，交换位置
                if(arr[j-1]>arr[j]){
                    temp= arr[j-1];
                    arr[j-1]= arr[j];
                    arr[j]= temp;
                    //下标为j的元素与下标为j-1的元素发生了数据交换
                    pos= j;
                }
            }
            //下一轮排序时只对下标小于pos的元素排序，下标大于等于pos的元素已经排好
            endPoint = pos - 1;

            System.out.println("第" + (counter++ )+ "轮结果: " + Arrays.toString(arr));
        }
    }

    /**
     * 传统的冒泡算法每次排序只确定了最大值，我们可以在每次循环之中进行正反两次冒泡，分别找到最大值和最小值，如此可使排序的轮数减少一半。
     * @param arr
     */
    public static void test4(int[] arr){
        int temp;
        int low = 0;
        int high = arr.length - 1;
        int counter = 1;
        while(low < high){
            //正向冒泡，确定最大值
            for(int i = low; i < high; i++){
                //如果前一位大于后一位，交换位置
                if(arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }

            --high;

            //反向冒泡，确定最小值
            for(int j = high; j > low; j--){
                //如果前一位大于后一位，交换位置
                if(arr[j]<arr[j-1]){
                    temp= arr[j];
                    arr[j]= arr[j-1];
                    arr[j-1]= temp;
                }
            }
            ++low;
            System.out.println("第" + (counter++ )+ "轮结果: " + Arrays.toString(arr));
        }
    }

}
