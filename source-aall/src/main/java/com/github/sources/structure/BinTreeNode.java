package com.github.sources.structure;

/** */
public class BinTreeNode {

    private Node root;

    public static void main(String[] args) {
        int[] arr = {8, 5, 2, 1, 3, 4, 6, 7, 9};
        BinTreeNode tree = new BinTreeNode();
        for (int i = 0, len = arr.length; i < len; i++) {
            tree.insert(arr[i]);
        }
        System.out.println("前序遍历：");
        tree.preTraverse(tree.root);
        System.out.println("");
        System.out.println("中序遍历：");
        tree.midTraverse(tree.root);
        System.out.println("");
        System.out.println("后序遍历：");
        tree.postTraverse(tree.root);
        System.out.println("");

        System.out.println(hasPathSum(tree.root, 15));

        invertNode(tree.root);
        tree.preTraverse(tree.root);
        System.out.println();
    }

    public static Node invertNode(Node node) {
        if (node == null) {
            return null;
        }
        Node temp = node.left;
        node.left = invertNode(node.right);
        node.right = invertNode(temp);
        return node;
    }

    public static boolean hasPathSum(Node root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.value == 0) {
            return true;
        }
        return hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value);
    }

    // 后序遍历
    public void postTraverse(Node node) {
        if (node != null) {
            postTraverse(node.left);
            postTraverse(node.right);
            System.out.print(node.value + " ");
        }
    }

    // 中序遍历
    public void midTraverse(Node node) {
        if (node != null) {
            midTraverse(node.left);
            System.out.print(node.value + " ");
            midTraverse(node.right);
        }
    }

    // 前序遍历
    public void preTraverse(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preTraverse(node.left);
            preTraverse(node.right);
        }
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            node.left = insert(node.left, value);
        }
        return node;
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
