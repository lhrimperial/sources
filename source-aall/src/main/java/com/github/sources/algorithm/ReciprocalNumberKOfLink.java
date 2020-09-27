package com.github.sources.algorithm;

/** */
public class ReciprocalNumberKOfLink {

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode findKthToTail(ListNode listHead, int k) {
        // 参数校验(判断链表是否存在、k是否大于0)
        if (listHead == null || k <= 0) {
            return null;
        }

        // 前面的指针
        ListNode ahead = listHead;

        // 先让ahead向前走k-1步
        for (int i = 1; i <= k - 1; i++) {
            if (ahead.next != null) {
                ahead = ahead.next;
            } else {
                // 当链表的长度小于k时，则返回null
                return null;
            }
        }
        // 后面的指针
        ListNode behind = listHead;

        while (ahead.next != null) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode temp1 = new ListNode(2);
        ListNode temp2 = new ListNode(3);
        ListNode temp3 = new ListNode(4);
        ListNode temp4 = new ListNode(5);
        ListNode temp5 = new ListNode(6);
        ListNode temp6 = new ListNode(7);

        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;
        temp5.next = temp6;
        temp6.next = null;

        ListNode resultNode = findKthToTail(head, 2);
        if (resultNode != null) {
            System.out.println(resultNode.value);
        } else {
            System.out.println("您输入的参数有误！");
        }
    }
}
