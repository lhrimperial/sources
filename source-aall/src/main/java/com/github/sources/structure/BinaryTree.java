package com.github.sources.structure;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author hairen.long
 * @date 2019-06-20
 */
public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.test();
    }

    public void test() {
        int[] arr = {5, 2, 8, 1, 3, 4, 6, 7, 9};
        for (int i = 0, len = arr.length; i < len; i++) {
            insert(arr[i]);
        }

        System.out.println("前序遍历：");
        perOrderTraverse(root);
        System.out.println("\n是否存在某一整数路径：" + hasPathSum(root, 14));
        //        System.out.println("\n中序遍历：");
        //        middleOrderTraverse(root);
        //        System.out.println("\n后序遍历：");
        //        postOrderTraverse(root);
        //        System.out.println("\n二叉树深度：" + treeDepth(root));
        //        System.out.println("\n是否是平衡二叉树：" + isBalanced(root));
        //        System.out.println("\n是否是平衡二叉树V2：" + isBalancedV2(root));
        //        System.out.println("\n最短深度：" + minDepth(root));
        //        System.out.println("\n打印树图：\n");
        //        printNode(Collections.singletonList(root), 1, treeDepth(root));

        //        int[] perorder = {5, 2, 1, 3, 4, 8, 6, 7, 9};
        //        int[] inorder = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //        TreeNode node = buildTree(perorder, inorder);
        //        printNode(Collections.singletonList(node),1,treeDepth(node));
    }

    private TreeNode root = null;

    public void printNode(List<TreeNode> nodes, int level, int maxLevel) {
        if (CollectionUtils.isEmpty(nodes)) {
            return;
        }
        int floor = maxLevel - level;
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
        int agedLine = (int) Math.pow(2, (Math.max(floor - 1, 0)));

        printWhitespaces(firstSpaces);
        // 把每一层node拿出来打印
        List<TreeNode> newNodes = Lists.newArrayList();
        for (TreeNode node : nodes) {
            if (Objects.nonNull(node)) {
                System.out.print(node.getData());
                newNodes.add(node.getLeftNode());
                newNodes.add(node.getRightNode());
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= agedLine; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                // 有的子节点为空，打印空格
                if (nodes.get(j) == null) {
                    printWhitespaces(agedLine + agedLine + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeftNode() != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);

                if (nodes.get(j).getRightNode() != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }
                printWhitespaces(agedLine + agedLine - i);
            }
            System.out.println();
        }

        printNode(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0 || inorder.length <= 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[0]);
        int index = getIndex(inorder, preorder[0]);
        if (preorder.length == 1) {
            return treeNode;
        }
        if (index > 0) {
            int[] aa = Arrays.copyOfRange(preorder, 1, 1 + index);
            int[] bb = Arrays.copyOfRange(inorder, 0, index);
            treeNode.leftNode = buildTree(aa, bb);
        }
        if (index < inorder.length - 1) {
            int[] aa = Arrays.copyOfRange(preorder, 1 + index, preorder.length);
            int[] bb = Arrays.copyOfRange(inorder, index + 1, inorder.length);
            treeNode.rightNode = buildTree(aa, bb);
        }
        return treeNode;
    }

    public static int getIndex(int[] xx, int key) {
        for (int i = 0; i < xx.length; i++) {
            if (xx[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public boolean hasSub(TreeNode node1, TreeNode node2) {
        boolean result = false;
        if (Objects.nonNull(node1) && Objects.nonNull(node2)) {
            if (node1.data == node2.data) {
                result = isSub(node1, node2);
            }
            // 根节点不相等
            if (!result) {
                result = hasSub(node1.leftNode, node2);
            }
            if (!result) {
                result = hasSub(node1.rightNode, node2);
            }
        }
        return result;
    }

    /**
     * 两个节点是否相等
     *
     * @param node1
     * @param node2
     * @return
     */
    private boolean isSub(TreeNode node1, TreeNode node2) {
        //
        if (Objects.isNull(node2)) {
            return true;
        }
        if (Objects.isNull(node1)) {
            return false;
        }
        if (node1.getData() != node2.getData()) {
            return false;
        }
        return isSub(node1.leftNode, node2.leftNode) && isSub(node1.rightNode, node2.rightNode);
    }

    /**
     * 二叉树镜像
     *
     * @param node
     */
    public void mirrorTree(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        TreeNode left = node.getLeftNode();
        node.setLeftNode(node.getRightNode());
        node.setRightNode(left);

        mirrorTree(node.getLeftNode());
        mirrorTree(node.getRightNode());
    }

    /**
     * 求解是否存在某一整数的路径
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (Objects.isNull(root)) {
            return false;
        }
        sum -= root.getData();
        if (sum == 0 && Objects.isNull(root.getLeftNode()) && Objects.isNull(root.getRightNode())) {
            return true;
        }

        return hasPathSum(root.getLeftNode(), sum) || hasPathSum(root.getRightNode(), sum);
    }

    /**
     * 最短深度
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = minDepth(root.getLeftNode());
        int right = minDepth(root.getRightNode());
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    /**
     * 二叉树平衡判断，采用后序遍历+节点高度实现
     *
     * @param root
     * @return
     */
    public boolean isBalancedV2(TreeNode root) {
        return isBalancedV2(root, new Height(0));
    }

    public boolean isBalancedV2(TreeNode root, Height height) {
        if (Objects.isNull(root)) {
            return true;
        }
        Height left = new Height(0), right = new Height(0);
        if (!isBalancedV2(root.getLeftNode(), left)) {
            return false;
        }
        if (!isBalancedV2(root.getRightNode(), right)) {
            return false;
        }
        if (Math.abs(left.getHeight() - right.getHeight()) > 1) {
            return false;
        }
        height.setHeight(Math.max(left.getHeight(), right.getHeight()) + 1);
        return true;
    }

    /**
     * 求是否是平衡树，节点会计算多次深度
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        int leftDepth = treeDepth(root.getLeftNode());
        int rightDepth = treeDepth(root.getRightNode());
        int diff = leftDepth - rightDepth;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return isBalanced(root.getLeftNode()) && isBalanced(root.getRightNode());
    }

    /**
     * 求树的深度
     *
     * @param root
     * @return
     */
    public int treeDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int leftDepth = treeDepth(root.getLeftNode());
        int rightDepth = treeDepth(root.getRightNode());
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private TreeNode insert(TreeNode node, int data) {
        if (Objects.isNull(node)) {
            node = new TreeNode(data);
        } else if (node.getData() > data) {
            node.setLeftNode(insert(node.getLeftNode(), data));
        } else {
            node.setRightNode(insert(node.getRightNode(), data));
        }
        return node;
    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public void perOrderTraverse(TreeNode node) {
        if (Objects.nonNull(node)) {
            System.out.print(node.getData() + "\t");
            perOrderTraverse(node.getLeftNode());
            perOrderTraverse(node.getRightNode());
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void middleOrderTraverse(TreeNode node) {
        if (Objects.nonNull(node)) {
            middleOrderTraverse(node.getLeftNode());
            System.out.print(node.getData() + "\t");
            middleOrderTraverse(node.getRightNode());
        }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public void postOrderTraverse(TreeNode node) {
        if (Objects.nonNull(node)) {
            postOrderTraverse(node.getLeftNode());
            postOrderTraverse(node.getRightNode());
            System.out.print(node.getData() + "\t");
        }
    }

    @Data
    public static class Height {
        int height;

        public Height(int height) {
            this.height = height;
        }
    }

    @Data
    public static class TreeNode {
        private int data;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
