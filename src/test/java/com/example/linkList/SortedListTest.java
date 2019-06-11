package com.example.linkList;

import org.junit.Test;

public class SortedListTest {

    @Test
    public void test1(){
        SortedList list = new SortedList();

        list.insert(new Link(2, "ming"));
        list.insert(new Link(3, "hong"));
        list.insert(new Link(1, "qiang"));
        list.insert(new Link(4, "gang"));

        list.displayList();
    }
}
