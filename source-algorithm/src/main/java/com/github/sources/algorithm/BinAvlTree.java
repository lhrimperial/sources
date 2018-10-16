package com.github.sources.algorithm;

/**
 *
 */
public class BinAvlTree {

    static final int LH = 1;//左高
    static final int EH = 0;//等高
    static final int RH = -1;//右高
    //临时节点
    static Node tempNode = new Node();

    /** 全局变量,用于标识树是否增高 */
    static boolean taller = false;

    public static void main(String[] args){
        int[] a = { 3, 2, 1, 4, 5, 6, 7, 10, 9, 8 };
        Node t = null;
        for (int i = 0; i < a.length; i++) {
            t = insertAVL(t, a[i]);
            System.out.println(t+"\n");
        }

    }


    /**
     * 在平衡二叉树t中若不存在与e有相同关键字的结点则插入t中并返回
     * t，若插入e后使得t失去平衡则需要作平衡处理
     * @param t 平衡二叉排序树
     * @param e 待插入元素
     * @return
     */
    static Node insertAVL(Node t, int e) {
        if (null == t) {
            // 插入新结点。树长高，taller为true
            t = new Node();
            t.data = e;
            t.leftNode = t.rightNode = null;
            t.bf = EH;
            taller = true;
        } else {
            if (e == t.data) {
                // 树中已存在和e有相同关键字的结点则不再插入
                taller = false;
                return t;
            } else if (e < t.data) {
                // 当e小于根结点或子根节点则应继续在t的左子树中进行搜索
                Node lchild = insertAVL(t.leftNode, e);
                t.leftNode = lchild;
                if (!taller)
                    return t;
                if (taller) {// 已插入到t的左子树中且左子树"长高"
                    switch (t.bf) {// 检查t的平衡度
                        case LH:// 原本左子树比右子树高，需要作左平衡处理
                            tempNode = leftBalance(t);
                            t = tempNode;
                            taller = false;
                            break;
                        case EH:// 原本左右子树等高，现因左子树增高而树增高
                            t.bf = LH;
                            taller = true;
                            break;
                        case RH:// 原本右子树比左子树高，现左右子树等高
                            t.bf = EH;
                            taller = false;
                            break;
                    }
                }
            } else {// 应继续在t的右子树中进行搜索.
                Node rchild = insertAVL(t.rightNode, e);
                t.rightNode = rchild;
                if (!taller)
                    return t;
                if (taller) {// 已插入到 t的右子树中且右子树"长高"
                    switch (t.bf) {// 检查t的平衡度
                        case LH:// 原本左子树比右子树高，现左右子树等高
                            t.bf = EH;
                            taller = false;
                            break;
                        case EH:// 原本左右子树等高，现因右子树增高而树增高
                            t.bf = RH;
                            taller = true;
                            break;
                        case RH:// 原本右子树比左子树高，需要作右平衡处理
                            tempNode = rightBalance(t);
                            t = tempNode;
                            taller = false;
                            break;
                    }
                }
            }
        }
        return t;
    }


    static Node leftBalance(Node bt) {
        Node l, lr;
        l = bt.leftNode;// l指向bt的左子树根节点
        switch (l.bf) {
            // 检查左子树的平衡度，并作相应平衡处理
            case LH:/* 新结点插在bt左孩子的左子树上，需要进行右旋处理 */
                bt.bf = l.bf = EH;
                tempNode = rRotate(bt);
                bt = tempNode;
                break;
            case RH:/* 新结点插在bt的左孩子的右子树上，需要作双旋处理 */
                lr = l.rightNode;/* lr指向bt左孩子的右子树根 */
                switch (lr.bf) {/* 修改bt及其左孩子的平衡因子 */
                    case LH:
                        bt.bf = LH;
                        l.bf = EH;
                        break;
                    case EH:
                        bt.bf = l.bf = EH;
                        break;
                    case RH:
                        bt.bf = EH;
                        l.bf = LH;
                        break;
                }
                lr.bf = EH;
                tempNode = lRotate(bt.leftNode);/* 对bt的左孩子作左旋平衡处理 */
                rRotate(tempNode);/* 对bt作右旋平衡处理 */
                bt = tempNode;
        }
        return bt;

    }

    /**
     * 处理完成后返回平衡二叉树
     * @param bt 左轻右重的平衡二叉树
     * @return
     */
    static Node rightBalance(Node bt) {
        Node r, rr;
        r = bt.rightNode;// r指向bt的右子树根节点
        switch (r.bf) {
            // 检查右子树的平衡度，并作相应平衡处理
            case RH:/* 新结点插在bt右孩子的右子树上，需要进行左旋处理 */
                bt.bf = r.bf = EH;
                tempNode = lRotate(bt);
                bt = tempNode;
                break;
            case LH:/* 新结点输入在bt的右孩子的左子树上，需要作双旋处理 */
                rr = r.leftNode;/* rr指向bt右孩子的左子树根 */
                switch (rr.bf) {/* 修改bt及其左孩子的平衡因子 */
                    case LH:
                        bt.bf = RH;
                        r.bf = EH;
                        break;
                    case EH:
                        bt.bf = r.bf = EH;
                        break;
                    case RH:
                        bt.bf = LH;
                        r.bf = EH;
                        break;
                }
                rr.bf = EH;
                tempNode = rRotate(bt.rightNode);/* 对bt的右孩子作右旋平衡处理 */
                bt.rightNode = tempNode;
                tempNode = lRotate(bt);/* 对bt作左旋平衡处理 */
                bt = tempNode;
        }
        return bt;
    }


    /**
     * 右旋
     * 将节点左子树顺时针旋转，使得左子树成为父亲节点
     * 将左子树的右子树作为当前节点的左子树，当前节点作为左子树的右子树，当前节点替换为左子树
     * @param node
     * @return
     */
    public static Node rRotate(Node node) {
        Node left;
        left = node.leftNode;
        node.leftNode = left.rightNode;
        left.rightNode = node;
        node = left;
        return node;
    }

    /**
     * 左旋
     * 将节点的右子树绕节点逆时针旋转，使得右子树成为节点的父亲
     * 将右子树的左子树作为节点的右子树，将当前节点作为右子树的左子树，当前节点替换为右子树
     * @param node
     * @return
     */
    public static Node lRotate(Node node) {
        Node right;
        right = node.rightNode;
        node.rightNode = right.leftNode;
        right.leftNode = node;
        node = right;
        return  node;
    }

    public static class Node {
        int data;//节点数据
        int bf;//节点平衡因子
        Node leftNode;
        Node rightNode;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", bf=" + bf +
                    ", leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    '}';
        }
    }
}
