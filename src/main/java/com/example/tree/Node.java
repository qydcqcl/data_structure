package com.example.tree;

public class Node {

    int age;
    String name;
    Node leftChild;
    Node rightChild;

    public Node(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void displayNode(){
        System.out.println("name: " + name + " ,age: " + age);
    }
}
