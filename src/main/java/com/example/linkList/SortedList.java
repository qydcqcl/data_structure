package com.example.linkList;

public class SortedList {

    private Link first;

    public SortedList() {
        first = null;
    }

    /**
     * 插入
     * @param link
     */
    public void insert(Link link){
        Link previous = null;
        Link cur = first;
        //链表由小到大排列
        while(cur != null && link.age > cur.age){
            previous = cur;
            cur = cur.next;
        }

        //如果previous为null，则证明当前链结点为表头
        if(previous == null){
            first = link;
        }else{
            previous.next = link;
        }
        link.next = cur;
    }

    /**
     * 删除第一个链结点，返回删除的链结点引用
     * @return
     */
    public Link deleteFirst() throws Exception {
        if(isEmpty()){
            throw new Exception("链表为空");
        }
        Link temp = first;
        first = first.next;
        return temp;
    }

    /**
     * 打印出所有的链表元素
     */
    public void displayList(){
        Link cur = first;
        while(cur != null){
            cur.displayLink();
            cur = cur.next;
        }
    }

    private boolean isEmpty() {
        return first == null;
    }
}
