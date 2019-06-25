package com.example.sort.merge;

/**
 * @author hzq
 * @date 2019/6/24 13:05
 */
public class MergeSort {

    /**
     * 待排序的数组
     */
    private int [] array;

    public MergeSort(int [] array){
        this.array= array;
    }

    /**
     * 按顺序打印数组中的元素
     */
    public void display(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }

    /**
     * 归并排序
     */
    public void mergeSort(){
        //用于辅助排序的数组
        int[] workSpace = new int [array.length];
        recursiveMergeSort(workSpace,0,workSpace.length-1);
    }

    /**
     * 递归的归并排序
     * @param workSpace  辅助排序的数组
     * @param lowerBound 欲归并数组段的最小下标
     * @param upperBound 欲归并数组段的最大下标
     */
    private void recursiveMergeSort(int [] workSpace,int lowerBound,int upperBound){
        //该段只有一个元素，不用排序
        if(lowerBound== upperBound){
            return;
        }else{
            int mid = (lowerBound+upperBound)/2;
            //对低位段归并排序
            recursiveMergeSort(workSpace,lowerBound,mid);
            //对高位段归并排序
            recursiveMergeSort(workSpace,mid+1,upperBound);
            merge(workSpace,lowerBound,mid,upperBound);
            display();
        }
    }

    /**
     * 对数组array中的两段进行合并，lowerBound~mid为低位段，mid+1~upperBound为高位段
     * @param workSpace 辅助归并的数组，容纳归并后的元素
     * @param lowerBound 合并段的起始下标
     * @param mid 合并段的中点下标
     * @param upperBound 合并段的结束下标
     */
    private void merge(int [] workSpace,int lowerBound,int mid,int upperBound){

        ///低位段的起始下标
        int lowBegin = lowerBound;
        //低位段的结束下标
        int lowEnd = mid;
        //高位段的起始下标
        int highBegin = mid+1;
        //高位段的结束下标
        int highEnd = upperBound;
        //workSpace的下标指针
        int j = 0;
        //归并的元素总数
        int n = upperBound-lowerBound+1;

        while(lowBegin<=lowEnd && highBegin<=highEnd){
            if(array[lowBegin]<array[highBegin]){
                //将两者较小的那个放到workSpace中
                workSpace[j++]= array[lowBegin++];
            }else{
                workSpace[j++]= array[highBegin++];
            }
        }

        while(lowBegin<=lowEnd){
            workSpace[j++]= array[lowBegin++];
        }

        while(highBegin<=highEnd){
            workSpace[j++]= array[highBegin++];
        }

        for(j=0;j<n;j++){
            //将归并好的元素复制到array中
            array[lowerBound++]= workSpace[j];
        }

    }
}
