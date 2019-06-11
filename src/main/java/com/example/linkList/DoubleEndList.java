package com.example.linkList;

public class DoubleEndList {

    private Link first;
    private Link last;

    public DoubleEndList() {
        first = null;
        last = null;
    }

    /**
     * 插入到链表的前端
     * @param link
     */
    public void insertFirst(Link link){
        if(isEmpty()){
            last = link;
        }
        link.next = first;
        first = link;
    }

    /**
     * 插入到链表的末端
     * @param link
     */
    public void insertLast(Link link){
        if(isEmpty()){
            first = link;
        }else{
            last.next = link;
        }
        last = link;
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
        if(first.next == null){
            last = null;
        }
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
