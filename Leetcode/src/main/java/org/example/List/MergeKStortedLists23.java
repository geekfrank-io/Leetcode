package org.example.List;

public class MergeKStortedLists23 {
    public static void main(String[] orgs) {


    }

    // Definition for singly-linked list.
    class ListNode {
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

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode node=null;
            for (int i=0;i<lists.length;i++)
            {
                node=mergeTwoLists(node,lists[i]);
            }
            return node;
        }

        private ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null || b == null)
                return a != null ? a : b;

            ListNode head = new ListNode();
            ListNode temp = head;
            ListNode m = a, n = b;
            while (m != null && n != null) {
                if (m.val < n.val) {
                    temp.next = m;
                    m = m.next;
                } else {
                    temp.next = n.next;
                    n = n.next;
                }
                temp=temp.next;
            }
            temp.next=(n==null?m:n);
            return head;
        }
    }
}