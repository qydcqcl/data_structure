package com.example.avl;

public class AVLTreeNode {

    /**
     * 节点存储的数值
     */
    private long value;

    /**
     * 左孩子
     */
    AVLTreeNode left;

    /**
     * 右孩子
     */
    AVLTreeNode right;

    public AVLTreeNode(long value, AVLTreeNode left, AVLTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public AVLTreeNode getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode left) {
        this.left = left;
    }

    public AVLTreeNode getRight() {
        return right;
    }

    public void setRight(AVLTreeNode right) {
        this.right = right;
    }
}
