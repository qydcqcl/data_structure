package com.example.array;

public class OrderArray {

    private int[] intArray;
    private int length = 0;

    public OrderArray(int max) {
        intArray = new int[max];
    }

    /**
     * 用二分查找法定位某个元素，如果存在返回其下标，不存在则返回-1
     * @param target
     * @return
     */
    public int find(int target){
        //搜索段最小元素的小标
        int lowerBound = 0;
        //搜索段最大元素的下标
        int upperBound = length - 1;
        int curIn;

        //如果数组为空，直接返回-1
        if(upperBound < 0){
            return -1;
        }

        while(true){
            curIn = (lowerBound + upperBound) / 2;
            int vpub = intArray[curIn];
            if(target == vpub){
                return curIn;
            }else if(curIn == lowerBound){
                // 在当前下标与搜索段的最小下标重合时，代表搜索段中只包含1个或2个元素
                //既然走到该分支，证明上一个if分支不满足，即目标元素不等于低位元素
                //等于高位元素，返回
                if(intArray[upperBound] == target){
                    return upperBound;
                }else{
                    //高位元素也不等于目标元素，证明数组中没有该元素，搜索结束
                    return -1;
                }
            }else{
                //搜索段中的元素至少有三个，且当前元素不等于目标元素
                if(intArray[curIn] < target){
                    // 如果当前元素小于目标元素，则将下一个搜索段的最小下标置为当前元素的下标
                    lowerBound = curIn;
                }else{
                    // 如果当前元素大于目标元素，则将下一个搜索段的最大下标置为当前元素的下标
                    upperBound = curIn;
                }
            }
        }
    }

    /**
     * 插入
     * @param ele
     */
    public void insert(int ele){
        int location = 0;
        for(; location < length; location++){
            if(intArray[location] > ele){
                break;
            }
        }

        //将插入下标之后的所有元素后移一位
        for(int i = length; i > location; i--){
            intArray[i] = intArray[i - 1];
        }
        intArray[location] = ele;
        length++;
    }

    /**
     * 删除某个指定的元素值，删除成功则返回true，否则返回false
     * @param target
     * @return
     */
    public boolean remove(int target){
        int index = -1;
        if((index = find(target)) != -1){
            for(int i = index; i < length - 1; i++){
                intArray[i] = intArray[i + 1];
            }
            length--;
            return true;
        }else{
            return false;
        }
    }

    /**
     * 列出所有元素
     */
    public void display() {
        for (int i = 0; i < length; i++) {
            System.out.print(intArray[i] + "\t");
        }
        System.out.println();
    }


}
