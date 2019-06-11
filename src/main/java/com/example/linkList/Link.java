package com.example.linkList;

public class Link {

    public int age;
    public String name;
    public Link next;

    /**
     *  指向前一个链结点
     */
    public Link previous;

    public Link(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void displayLink(){
        System.out.println("name = " + name +" , age = " + age);
    }
}
