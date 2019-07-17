package com.github.happut.learndemospringboot.leecode.problem2;

import java.util.Stack;

public class Problem2 {


    public static void main(String[] args) {


        ListNode t = new ListNode(3);
        ListNode t2 = new ListNode(4);
        t2.next = t;

        ListNode t3 = new ListNode(2);
        t3.next = t2;

        ListNode listNode = reverseList(t3);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = false;

        ListNode result = null;
        ListNode current = null;

        while (l1 != null || l2 != null || flag == true) {
            int var1 = 0;
            if (l1 != null) {
                var1 = l1.val;
            }

            int var2 = 0;
            if (l2 != null) {
                var2 = l2.val;
            }

            int val = var1 + var2;
            if (flag == true) {
                val++;
                flag = false;
            }
            if (val >= 10) {
                flag = true;
                val -= 10;
            }
            ListNode curr = new ListNode(val);
            if (current != null) {
                current.next = curr;
            }
            current = curr;

            if (result == null) {
                result = current;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return result;
    }

    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();

        while(head.next!=null){
            stack.push(head);
            head = head.next;
        }

        ListNode newHead = head;
        ListNode curr = head;
        while(!stack.empty()){
            ListNode node = stack.pop();
            node.next = null;
            curr.next = node;
            curr = curr.next;
        }
        return newHead;

    }


}
