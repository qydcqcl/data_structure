package com.example.array;

public class Array {

    private String[] arrString;
    /**
     * 元素的个数
     */
    private int length = 0;

    /**
     * 构造方法，传入数组最大长度
     * @param max
     */
    public Array(int max) {
        arrString = new String[max];
    }

    /**
     * 检测数组是否包含某个元素，如果存在返回其下标，不存在则返回-1
     * @param target
     * @return
     */
    public int contains(String target){
        int index = -1;
        for(int i = 0; i < length; i++){
            if(arrString[i].equals(target)){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 插入
     * @param ele
     */
    public void insert(String ele){
        arrString[length] = ele;
        length++;
    }

    /**
     * 删除某个指定的元素值，删除成功则返回true，否则返回false
     */
    public boolean remove(String target){
        int index = -1;
        if((index = contains(target)) != -1){
            for(int i = index; i < length - 1; i++){
                arrString[i] = arrString[i++];
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
    public void display(){
        for(String s : arrString){
            System.out.print(s + "\t");
        }
        System.out.println();
    }

}
