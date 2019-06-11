package com.example.linkList;

import org.junit.Test;

public class LinkListTest {

    @Test
    public void test1(){
        LinkList list = new LinkList();
        list.insertFirst(new Link(1, "xioaming"));
        list.insertFirst(new Link(2, "xioahong"));
        list.insertFirst(new Link(3, "xioaqiang"));
        list.insertFirst(new Link(4, "xioagang"));

        Link link = list.find(2);
        link.displayLink();
        System.out.println(link.next.age);
    }
}
