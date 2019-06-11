package com.example.huffman;

public class Node {

    /**
     * 树节点存储的关键字，如果是非叶子节点为空
     */
    private String key;

    /**
     * 关键字词频
     */
    private int frequency;

    private Node left;

    private Node right;

    /**
     * 优先级队列中指向下一个节点的引用
     */
    private Node next;

    public Node(int frequency) {
        this.frequency = frequency;
    }

    public Node(int frequency, String key) {
        this.key = key;
        this.frequency = frequency;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
