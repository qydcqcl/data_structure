package com.example.avl;

public class AVLTree {

    /**
     * 根节点
     */
    public AVLTreeNode root;

    /**
     * 插入
     * @param insertValue
     */
    public void insert(long insertValue){
        root = insert(root, insertValue);
    }

    /**
     * 插入操作的递归实现
     * @param subTree
     * @param insertValue
     * @return
     */
    private AVLTreeNode insert(AVLTreeNode subTree, long insertValue) {
        if(subTree == null){
            return new AVLTreeNode(insertValue, null, null);
        }

        if(insertValue < subTree.getValue()){
            //插入左子树
            subTree.left = insert(subTree.left, insertValue);
            if(unbalanceTest(subTree)){
                if(insertValue < subTree.left.getValue()){
                    //LL型失衡
                    subTree = leftLeftRotation(subTree);
                }else{
                    //LR型失衡
                    subTree = leftRightRotation(subTree);
                }
            }
        }else if(insertValue > subTree.getValue()){
            //插入有子树
            subTree.right = insert(subTree.right, insertValue);
            if(unbalanceTest(subTree)){
                if(insertValue < subTree.right.getValue()){
                    //RL型失衡
                    subTree = rightLeftRotation(subTree);
                }else{
                    //RR型失衡
                    subTree = rightRightRotation(subTree);
                }
            }
        }else{
            throw new RuntimeException("duplicate value: " + insertValue);
        }
        return subTree;
    }

    /**
     * RR型旋转
     * @param k1
     * @return
     */
    private AVLTreeNode rightRightRotation(AVLTreeNode k1) {
        AVLTreeNode k2;
        k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    /**
     * RL型旋转
     * @param k1
     * @return
     */
    private AVLTreeNode rightLeftRotation(AVLTreeNode k1) {
        k1.right = leftLeftRotation(k1.right);
        return rightRightRotation(k1);
    }

    /**
     * LR型旋转
     * @param k3
     * @return
     */
    private AVLTreeNode leftRightRotation(AVLTreeNode k3) {
        k3.left = rightRightRotation(k3.left);
        return leftLeftRotation(k3);
    }

    /**
     * LL型旋转
     * @param k2
     * @return
     */
    private AVLTreeNode leftLeftRotation(AVLTreeNode k2) {
        AVLTreeNode k1;
        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    /**
     * 判断是否失衡
     * @param treeRoot
     * @return
     */
    private boolean unbalanceTest(AVLTreeNode treeRoot) {
        int leftHeight = getDepth(treeRoot.left, 1);
        int rightHeight = getDepth(treeRoot.right, 1);
        int diff = Math.abs(leftHeight - rightHeight);
        return diff > 1;
    }

    /**
     * 获取树的深度
     * @param treeRoot
     * @param initDeep
     * @return
     */
    private int getDepth(AVLTreeNode treeRoot, int initDeep) {
        if(treeRoot == null){
            return initDeep;
        }
        int leftHeight = initDeep;
        int rightHeight = initDeep;
        if(treeRoot.left != null){
            leftHeight = getDepth(treeRoot.left, initDeep++);
        }
        if(treeRoot.right != null){
            rightHeight = getDepth(treeRoot.right, initDeep++);
        }
        return Math.max(leftHeight, rightHeight);
    }

    /**
     * 删除
     * @param value
     */
    public void remove(long value){
        root = remove(root, value);
    }

    /**
     * 删除操作的递归实现
     * @param tree
     * @param value
     * @return
     */
    private AVLTreeNode remove(AVLTreeNode tree, long value) {
        if(tree == null){
            return tree;
        }

        if(value < tree.getValue()){
            //要删除的节点在左子树
            tree.left = remove(tree.left, value);
        }else if(value > tree.getValue()){
            //要删除的节点在右子树
            tree.right = remove(tree.right, value);
        }else if(value == tree.getValue()){
            //要删除的节点就是本身
            if(tree.left != null && tree.right != null){
                //左右子树都存在
                if(getDepth(tree.left, 1) > getDepth(tree.right, 1)){
                    /**
                     * 如果tree的左子树比右子树高:
                     * 1. 找出tree的左子树中的最大节点
                     * 2. 将该最大节点的值赋值给tree。
                     * 3. 删除该最大节点。
                     * 这类似于用"tree的左子树中最大节点"做"tree"的替身
                     * 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的
                     */
                    AVLTreeNode max = getMaxNode(tree.left);
                    tree.setValue(max.getValue());
                    tree.left = remove(tree.left, max.getValue());
                }else{
                    /**
                     * 如果tree的左子树不高于右子树:
                     * 1. 找出tree的右子树中的最小节点
                     * 2. 将该最小节点的值赋值给tree。
                     * 3. 删除该最小节点。
                     * 这类似于用"tree的右子树中最小节点"做"tree"的替身
                     * 采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的
                     */
                    AVLTreeNode min = getMinNode(tree.right);
                    tree.setValue(min.getValue());
                    tree.right = remove(tree.right, min.getValue());
                }

            }else{
                //
                tree = tree.left == null ? tree.right : tree.left;
            }


        }else{
            System.out.println("no node matched value: " + value);
        }
        return tree;
    }

    /**
     * 获取值最小节点
     * @param node
     * @return
     */
    private AVLTreeNode getMinNode(AVLTreeNode node) {
        if(node == null){
            return null;
        }
        if(node.left != null){
            return getMinNode(node.left);
        }else{
            return node;
        }
    }

    /**
     * 获取值最大节点
     * @param node
     * @return
     */
    private AVLTreeNode getMaxNode(AVLTreeNode node) {
        if(node == null){
            return null;
        }

        if(node.right != null){
            return getMaxNode(node.right);
        }else{
            return node;
        }
    }
}
