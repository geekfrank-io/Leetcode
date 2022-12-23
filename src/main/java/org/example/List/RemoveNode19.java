package org.example.List;

public class RemoveNode19 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1,node2);
        head.next = node1;
        Solution solution = new Solution();
        //int length=solution.GetListNodeLength(head,-1);
        //System.out.println(length);
        ListNode newHead = solution.removeNthFromEnd(head, 1);
        //System.out.println(newHead);
        int length = solution.GetListNodeLength(newHead, -1);
       System.out.println(length);
    }

    public static class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            int length = GetListNodeLength(head, -1);
            RemoveListNode(head, -1, length - n - 1);
            return head;
        }

        private int GetListNodeLength(ListNode node, int length) {
            length++;
            if (node!=null)
            {
               // System.out.print(node.val+"    ");
            }
            if (node.next != null) {
                length=GetListNodeLength(node.next, length);
            }
            return length;
        }

        private void RemoveListNode(ListNode node, int i, int targetParent) {

            System.out.println(i+" "+targetParent);
            if (node == null) return;
            //定位到目标结点的父节点
            if (i == targetParent) {
                ListNode temp1 = null;
                if (node.next != null) {
                    temp1 = node.next;
                }
                ListNode temp2 = null;
                if (temp1.next != null) {
                    temp2 = temp1.next;
                }
                node.next = temp2;
                return;
            } else {
                RemoveListNode(node.next, ++i, targetParent);
            }

        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
