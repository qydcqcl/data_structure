package com.example.linkList;

public class LinkList {

    private Link first;

    public LinkList() {
        first = null;
    }

    /**
     * 插入链表的顶端
     * @param link
     */
    public void insertFirst(Link link){
        link.next = first;
        first = link;
    }

    /**
     * 删除第一个链结点，返回删除的链结点引用
     * @return
     */
    public Link deleteFirst() throws Exception {
        if(isEmpty()){
            throw new Exception("链表为空!");
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

    /**
     * 删除属性为指定值的链结点
     * @param key
     * @return
     */
    public Link delete(int key){
        //要返回的节点
        Link link = null;

        //当前节点
        Link previous = null;
        Link cur = first;
        Link next = cur.next;

        while(cur != null){
            if(key == cur.age){
                link = cur;
                if(previous == null){
                    //如果当前链结点的前驱为null，证明当其为链表的第一个链结点，删除该链结点后需要对first属性重新赋值
                    first = next;
                }else{
                    //删除操作，即将前驱的next指针指向当前链结点的next，链表中将去当前链结点这一环
                    previous.next = next;
                }
                break;
            }else if(cur.next == null){
                //当前链结点不是要找的目标且下一个链结点为null，则证明没有找到目标
                break;
            }else{
                //当前链结点不是要找的目标且存在下一个链结点，则向后继续寻找
                previous = cur;
                cur = next;
                next = cur.next;
//                next = next.next;
//                cur = cur.next;
//                previous = cur;
            }

        }
        return link;
    }

    /**
     * 查找属性为指定值的链结点
     * @param key
     * @return
     */
    public Link find(int key){
        //要返回的节点
        Link link = null;

        //当前节点
        Link cur = first;
        Link next = cur.next;
        Link previous = null;

        while(cur != null){
            if(key == cur.age){
                link = cur;
                break;
            }else if(cur.next == null){
                //当前链结点不是要找的目标且下一个链结点为null，则证明没有找到目标
                break;
            }else{
                //当前链结点不是要找的目标且存在下一个链结点，则向后继续寻找
                previous = cur;
                cur = next;
                next = cur.next;

//                next = next.next;
//                cur = cur.next;
//                previous = cur;
            }
        }
        return link;
    }

    /**
     * 判断链表为空
     * @return
     */
    private boolean isEmpty() {
        return first == null;
    }
}
