package com.example.sort.quik;

/**
 * @author hzq
 * @date 2019/6/24 20:26
 */
public class QuikSort {

    private int[] arr;

    public QuikSort(int[] arr) {
        this.arr = arr;
    }

    public void quikSort(){
        recursiveQuikSort(0, arr.length - 1);
    }

    private void recursiveQuikSort(int low, int high) {
        if(low >= high){
            return;
        }else{
            //以第一个元素为基准
            int pivot = arr[low];
            //对数组进行划分，比pivot小的元素在低位段，比pivot大的元素在高位段
            int partition = partition(low, high, pivot);

            display();

            //对划分后的低位段进行快速排序
            recursiveQuikSort( low,partition-1);
            //对划分后的高位段进行快速排序
            recursiveQuikSort(partition+1, high);
        }

    }

    /**
     * 以pivot为基准对下标low到high的数组进行划分
     * @param low 数组段的最小下标
     * @param high 数组段的最大下标
     * @param pivot 划分的基准元素
     * @return 划分完成后基准元素所在位置的下标
     */
    private int partition(int low, int high, int pivot) {
        while(low < high){
            while(low<high && arr[high] >= pivot){
                //从右端开始扫描，定位到第一个比pivot小的元素
                high--;
            }
            swap(low, high);
            //从左端开始扫描，定位到第一个比pivot大的元素
            while(low<high && arr[low] <= pivot){
                low++;
            }
            swap(low,high);
        }
        return low;
    }

    /**
     * 交换数组中两个元素的数据
     * @param low
     * @param high
     */
    private void swap(int low, int high) {
        int temp = arr[high];
        arr[high] = arr[low];
        arr[low] = temp;
    }

    /**
     * 按顺序打印数组中的元素
     */
    public void display(){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
