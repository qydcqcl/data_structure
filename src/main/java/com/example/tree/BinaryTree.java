package com.example.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
        root = null;
    }

    /**
     * 按关键字查找节点
     * @param key
     * @return
     */
    public Node find(int key){
        Node cur = root;
        if(cur == null){
            return null;
        }
        while(cur.age != key){
            if(key < cur.age){
                //如果关键字比当前节点小，转向左子节点
                cur = cur.leftChild;
            }else{
                //如果关键字比当前节点大，转向右子节点
                cur = cur.rightChild;
            }
            if(cur == null){
                return null;
            }
        }
        return cur;
    }

    /**
     * 插入新节点
     * @param node
     */
    public void insert(Node node){
        if(root == null){
            root = node;
        }else{
            Node cur = root;

            while(true){
                if(node.age < cur.age){
                    if(cur.leftChild == null){
                        //找到了要插入节点的父节点
                        cur.leftChild = node;
                        return;
                    }
                    cur = cur.leftChild;
                }else{
                    if(cur.rightChild == null){
                        //找到了要插入节点的父节点
                        cur.rightChild = node;
                        return;
                    }
                    cur = cur.rightChild;
                }
            }
        }
    }

    /**
     * 删除指定节点
     * @param node
     * @return
     */
    public boolean delete(Node node){
        if(root == null){
            return false;
        }

        //记录目标节点是否为父节点的左子节点
        boolean isLeftChild = true;
        //要删除的节点
        Node cur = root;
        //要删除节点的父节点
        Node parent = null;

        //确定要删除节点和它的父节点
        while(cur.age != node.age){
            parent = cur;
            if(cur.age < node.age){
                //目标节点小于当前节点，跳转左子节点
                cur = cur.leftChild;
            }else{
                //目标节点大于当前节点，跳转右子节点
                isLeftChild = false;
                cur = cur.rightChild;
            }
            if(cur == null){
                return false;
            }
        }

        if(cur.leftChild == null && cur.rightChild == null){
            //目标节点为叶子节点（无子节点）
            if(cur == root){
                //要删除的为根节点
                root = null;
            }else if(isLeftChild){
                //要删除的不是根节点，则该节点肯定有父节点，该节点删除后，需要将父节点指向它的引用置空
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
        }else if(cur.leftChild == null){
            //只有一个右子节点
            if(cur == root){
                root = cur.rightChild;
            }else if(isLeftChild){
                parent.leftChild = cur.rightChild;
            }else{
                parent.rightChild = cur.rightChild;
            }
        }else if(cur.rightChild == null){
            //只有一个左子节点
            if(cur == root){
                root = cur.leftChild;
            }else if(isLeftChild){
                parent.leftChild = cur.leftChild;
            }else{
                parent.rightChild = cur.leftChild;
            }
        }else{
            //有两个子节点
            //第一步要找到欲删除节点的后继节点
            Node successor = cur.rightChild;
            Node successorParent = null;
            while(successor.leftChild != null){
                successorParent = successor;
                successor = successor.leftChild;
            }

            if(successorParent != null){
                //欲删除节点的后继不是它的右子节点
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = cur.rightChild;
            }
            //欲删除节点的右子节点就是它的后继，证明该后继无左子节点，则将以后继节点为根的子树上移即可
            if (cur == root) {
                //要删除的为根节点，则将后继设置为根，且根的左子节点设置为欲删除节点的做左子节点
                root = successor;
                root.leftChild = cur.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = successor;
                successor.leftChild = cur.leftChild;
            } else {
                parent.rightChild = successor;
                successor.leftChild = cur.leftChild;
            }
        }
        return true;
    }


    /**
     * 前序遍历
     */
    public static final int PREORDER = 1;
    /**
     * 中序遍历
     */
    public static final int INORDER = 2;
    /**
     * 后序遍历
     */
    public static final int POSTORDER = 3;

    public void traverse(int type){
        switch (type){
            case PREORDER:
                System.out.println("前序遍历: \t");
                preorder(root);
                System.out.println();
                break;
            case INORDER:
                System.out.println("中序遍历: \t");
                inorder(root);
                System.out.println();
                break;
            case POSTORDER:
                System.out.println("后序遍历: \t");
                postorder(root);
                System.out.println();
                break;
        }
    }

    public void preorder(Node currentRoot) {
        if(currentRoot != null){
            System.out.println(currentRoot.age + "\t");
            preorder(currentRoot.leftChild);
            preorder(currentRoot.rightChild);
        }
    }

    public void inorder(Node currentRoot){
        if(currentRoot != null){
            //先对当前节点的左子树对进行中序遍历
            inorder(currentRoot.leftChild);
            //然后访问当前节点
            System.out.println(currentRoot.age + "\t");
            //最后对当前节点的右子树对进行中序遍历
            insert(currentRoot.rightChild);
        }
    }

    public void postorder(Node currentRoot){
        if(currentRoot != null){
            postorder(currentRoot.leftChild);
            postorder(currentRoot.rightChild);
            System.out.println(currentRoot.age + "\t");
        }
    }

    public int getTreeDepth(){
        if(root == null){
            return 0;
        }
        return getDepth(root, 1);
    }

    private int getDepth(Node currentNode, int initDeep) {
        int deep = initDeep;
        int leftDeep = initDeep;
        int rightDeep = initDeep;
        if(currentNode.leftChild != null){
            leftDeep = getDepth(currentNode.leftChild, deep++);
        }
        if(currentNode.rightChild != null){
            rightDeep = getDepth(currentNode.rightChild, deep++);
        }
        return Math.max(leftDeep, rightDeep);
    }

    /**
     * 返回关键值最大的节点
     * @return
     */
    public Node getMax(){
        if(isEmpty()){
            return null;
        }
        Node cur = root;
        while(cur.rightChild != null){
            cur = cur.rightChild;
        }
        return cur;
    }

    /**
     * 返回关键值最小的节点
     * @return
     */
    public Node getMin(){
        if(isEmpty()){
            return null;
        }
        Node cur = root;
        while(cur.leftChild != null){
            cur = cur.leftChild;
        }
        return cur;
    }

    /**
     * 以树的形式打印出该树
     */
    public void displayTree(){
        int depth = getTreeDepth();
        List<Node> currentLayerNodes = new ArrayList<>();
        currentLayerNodes.add(root);
        int layerIndex = 1;
        while(layerIndex <= depth){
            //在节点之前和之后应该打印几个空位
            int NodeBlankNum  = (int) Math.pow(2, depth - layerIndex) - 1;
            for(int i = 0; i < currentLayerNodes.size(); i++){
                Node node = currentLayerNodes.get(i);
                //打印节点之前的空位
                printBlank(NodeBlankNum);

                if(node == null){
                    //如果该节点为null，用空位代替
                    System.out.print("*\t");
                }else{
                    //打印该节点
                    System.out.print("* " + node.age + "\t");
                }

                //打印节点之后的空位
                printBlank(NodeBlankNum);
                //补齐空位
                System.out.print("*\t");
            }
            System.out.println();
            layerIndex++;
            //获取下一层所有的节点
            currentLayerNodes = getAllNodeOfThisLayer(currentLayerNodes);
        }
    }

    /**
     * 获取指定节点集合的所有子节点
     * @param parentNodes
     * @return
     */
    private List<Node> getAllNodeOfThisLayer(List<Node> parentNodes) {
        List<Node> list = new ArrayList<>();
        Node parentNode;

        for(int i = 0; i < parentNodes.size(); i++){
            parentNode = parentNodes.get(i);
            if(parentNode != null){
                if(parentNode.leftChild != null){
                    //如果上层的父节点存在左子节点，加入集合
                    list.add(parentNode.leftChild);
                }else{
                    //如果上层的父节点不存在左子节点，用null代替，一样加入集合
                    list.add(null);
                }

                if(parentNode.rightChild != null){
                    list.add(parentNode.rightChild);
                }else{
                    list.add(null);
                }

            }else{
                //如果上层父节点不存在，用两个null占位，代表左右子节点
                list.add(null);
                list.add(null);
            }
        }
        return list;
    }

    /**
     * 打印指定个数的空位
     * @param num
     */
    public void printBlank(int num){
        for(int i = 0; i < num; i++){
            System.out.print("*\t");
        }
    }

    /**
     * 判空
     * @return
     */
    private boolean isEmpty() {
        return root == null;
    }

    /**
     * 判断是否为叶子节点
     * @param node
     * @return
     */
    public boolean isLeaf(Node node){
        return node.leftChild != null || node.rightChild != null;
    }

    /**
     * 获取根节点
     * @return
     */
    public Node getRoot(){
        return root;
    }
}
