package com.github.sources.algorithm.structure;

/**
 * 二叉排序树
 */
public class BinaryTree {

    public static void main(String[] args){
        int[] arr = {8, 5, 2, 1, 3, 4, 6, 7, 9};
        BinaryTree tree = new BinaryTree();
        for (int i = 0,len = arr.length; i < len; i++) {
            tree.insert(arr[i]);
        }
        System.out.println("中序遍历");
        inOrderTraverse(tree.root);
        System.out.println("\n前序遍历");
        preOrderTraverse(tree.root);
        System.out.println("\n后序遍历");
        postOrderTraverse(tree.root);

    }

    /**
     * 根节点
     */
    private Node root = null;

    /**
     * 二叉树结构
     */
    public static class Node {
        private int data;
        private Node leftNode;
        private Node rightNode;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }

    /**
     * 构建二叉排序树
     * @param data
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else if (data > node.getData()) {
            node.setRightNode(insert(node.getRightNode(), data));
        } else {
            node.setLeftNode(insert(node.getLeftNode(), data));
        }
        return node;
    }

    /**
     * 前序遍历
     * @param node
     */
    public static void preOrderTraverse(Node node) {
        if (node != null) {
            System.out.print(node.getData() + "\t");
            preOrderTraverse(node.getLeftNode());
            preOrderTraverse(node.getRightNode());
        }
    }

    /**
     * 中序遍历
     * @param node
     */
    public static void inOrderTraverse(Node node) {
        if (node != null) {
            inOrderTraverse(node.getLeftNode());
            System.out.print(node.getData() + "\t");
            inOrderTraverse(node.getRightNode());
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    public static void postOrderTraverse(Node node) {
        if (node != null) {
            postOrderTraverse(node.getLeftNode());
            postOrderTraverse(node.getRightNode());
            System.out.print(node.getData() + "\t");
        }
    }
}
