package com.example.sort.selection;

import java.util.Arrays;

/**
 * @author hzq
 * @date 2019/6/22 18:10
 * @desc 从第一个元素开始，扫描整个待排数组，找到最小的元素放之后再与第一个元素交换位置，
 * 然后再从第二个元素开始，继续寻找最小的元素与第二个元素交换位置，依次类推。
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {20,40,30,10,60,50};
        test2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void test1(int[] arr){
        int temp;
        int min;
        int counter = 1;
        for(int i = 0; i < arr.length - 1; i++){

            min = i;
            for(int j = i + 1; j < arr.length - 1; j++){
                //每完成一轮排序，就确定了一个相对最小元素，下一轮排序只对后面的元素排序
                if(arr[min] > arr[j]){
                    //如果待排数组中的某个元素比当前元素小，minPoint指向该元素的下标
                    min = j;
                }
            }

            if(i != min){
                //如果发现了更小的元素，交换位置
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }

            System.out.println("第" + (counter++) + "轮排序结果: " + Arrays.toString(arr));
        }
    }

    public static void test2(int[] arr){
        int min;
        int max;
        int temp;
        int len = arr.length;
        int counter = 1;
        for(int i = 0; i < len / 2; i++){
            min = i;
            max = i;
            for(int j =  i + 1; j <= len - 1 - i; j++){
                //每完成一轮排序，就确定了两个最值，下一轮排序时比较范围减少两个元素
                if(arr[min] > arr[j]){
                    //如果待排数组中的某个元素比当前元素小，minPoint指向该元素的下标
                    min = j;
                    continue;
                }else if(arr[max] < arr[j]){
                    //如果待排数组中的某个元素比当前元素大，maxPoint指向该元素的下标
                    max = j;
                }
            }
            if(min != i){
                //如果发现了更小的元素，与第一个元素交换位置
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;

                //原来的第一个元素已经与下标为minPoint的元素交换了位置
                //如果之前maxPoint指向的是第一个元素，那么需要将maxPoint重新指向array[minPoint]
                //因为现在array[minPoint]存放的才是之前第一个元素中的数据
                if(max == i){
                    max = min;
                }
            }

            if(max != len - 1 - i){
                //如果发现了更大的元素，与最后一个元素交换位置
                temp = arr[len - 1 - i];
                arr[len - 1 - i] = arr[max];
                arr[max] = temp;
            }
            System.out.println("第" + (counter++) + "轮排序结果： " + Arrays.toString(arr));
        }
    }

}
