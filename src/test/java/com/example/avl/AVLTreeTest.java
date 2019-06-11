package com.example.avl;

import org.junit.Test;

public class AVLTreeTest {

    @Test
    public void test1(){
        AVLTree tree = new AVLTree();
        int arr[]= {3,2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};
        for (int a : arr) {
            tree.insert(a);
        }
        preorder(tree.root);
        System.out.println();
    }

    private void preorder(AVLTreeNode currentRoot) {
        if(currentRoot != null){
            System.out.print(currentRoot.getValue() + "\t");
            preorder(currentRoot.left);
            preorder(currentRoot.right);
        }
    }
}
