package com.example.sort.shell;

/**
 * @author hzq
 * @date 2019/6/25 12:54
 */
public class ShellSort {

    private int[] arr;

    public ShellSort(int[] arr) {
        this.arr = arr;
    }

    /**
     * 希尔排序
     */
    public void shellSort(){
        int len = arr.length;
        int counter = 1;

        int h = 1;
        //确定第一轮排序时的间隔
        while(3 * h + 1 < len){
            h = 3 * h + 1;
        }

        while(h > 0){
            for(int i = 0; i < h; i++){
                //对间隔为h的元素进行插入排序
                shellInsertSort(i, h);
            }
            h = (h - 1) / 3;

            System.out.print("第"+counter+"轮排序结果：");
            display();
            counter++;
        }
    }

    /**
     * 希尔排序内部使用的插入排序:
     * 需要进行插入排序的元素为array[beginIndex]、array[beginIndex+increment]、array[beginIndex+2*increment]...
     * @param beginIndex
     * @param increment
     */
    private void shellInsertSort(int beginIndex, int increment) {
        //欲插入元素的下标
        int targetIndex = beginIndex + increment;

        while (targetIndex < arr.length) {
            int temp = arr[targetIndex];

            //前一个元素下标，间隔为increment
            int previousIndex = targetIndex - increment;

            while(previousIndex >= 0 && arr[previousIndex] > temp){
                //比欲插入数据项大的元素后移一位
                arr[previousIndex + increment] = arr[previousIndex];
                previousIndex = previousIndex - increment;
            }

            //插入到合适的位置
            arr[previousIndex+increment]= temp;
            //插入下一个元素
            targetIndex =targetIndex+increment;
        }
    }

    /**
     * 按顺序打印数组中的元素
     */
    public void display(){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
}
