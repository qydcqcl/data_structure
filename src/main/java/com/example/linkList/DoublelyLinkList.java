package com.example.linkList;

public class DoublelyLinkList {

    private Link first;
    private Link last;

    public DoublelyLinkList() {
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
        }else{
            first.previous = link;
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
            link.previous = last;
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
        if(temp.next == null){
            //如果只有一个链结点，则删除后会影响到last指针
            last = null;
        }else{
            //如果至少有两个链结点，则将第二个链结点的previous设为null
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    /**
     * 删除最后一个链结点，返回删除的链结点引用
     * @return
     */
    public Link deleteLast() throws Exception {
        if(isEmpty()){
            throw new Exception("链表为空");
        }
        Link temp = last;
        if(temp.previous == null){
            //如果只有一个链结点，则删除后会影响到first指针
            first = null;
        }else{
            //如果至少有两个链结点，则将倒数第二个链结点的next设为null
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    /**
     * 查找属性为指定值的链结点
     * @param key
     * @return
     */
    public Link find(int key){
        Link cur = first;
        while(cur != null && cur.age != key){
            if(cur.next == null){
                return null;
            }
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 在指定链结点之后插入，操作成功返回true，操作失败返回false
     * @param link
     * @return
     */
    public boolean insertAfter(Link link){
        Link target = find(link.age);
        if(target == null){
            //没找到插入的参照链结点
            return false;
        }else{
            if(target.next == null){
                //参照链结点为表尾
                insertLast(link);
            }else{
                //该链表至少有两个链结点
                target.next.previous = link;
                link.next = target.next;
                //必须执行完上面两步，才能执行下面这两步
                //上面两步处理了link和它下一个链结点的关系
                //下面两步处理了link和它上一个链结点的关系
                target.next = link;
                link.previous = target;
            }
        }
        return true;
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
