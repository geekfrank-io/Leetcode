package org.example.List;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInKGroup {
    static public  void main(String[] args)
    {
        ListNode node8=new ListNode(8,null);
        ListNode node7=new ListNode(7,node8);
        ListNode node6=new ListNode(6,node7);
        ListNode node5=new ListNode(5,node6);
        ListNode node4=new ListNode(4,node5);
        ListNode node3=new ListNode(3,node4);
        ListNode node2=new ListNode(2,node3);
        ListNode node1=new ListNode(1,node2);


        Solution solution =new Solution();
         ListNode result=solution.reverseKGroup(node1,2);
         while (result!=null)
         {
             System.out.println(result.Value);
             result=result.next;
         }
    }



}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ListNode returnHead=new ListNode(0);
        returnHead.next=head;
        ListNode temp=new ListNode(0);
        temp.next=head;
        for(int i=0;i<k;i++)
        {
            if(returnHead.next==null)
            {
                return temp.next;
            } else{
                returnHead.next=returnHead.next.next;
            }
        }
        ListNode flag=new ListNode(0);
        flag.next=head;
        List<ListNode> lists=new ArrayList<ListNode>();
        while(isMultipleK(flag.next,k))
        {
            lists.clear();
            ListNode node =new ListNode(0);
            node.next=flag.next;
            for(int i=0;i<k;i++)
            {
                lists.add(node.next);
                node.next=node.next.next;
            }
            flag.next=lists.get(k-1);
            lists.get(0).next=node.next;
            for(int i=1;i<k;i++)
            {
                lists.get(k-i).next=lists.get(k-1-i);
            }
            flag=lists.get(0);
        }
        return returnHead.next;
    }
    public boolean isMultipleK(ListNode node,int k)
    {
        ListNode nodeFlag=new ListNode(0);
        nodeFlag.next=node;
        for(int i=0;i<k;i++)
        {
            if(nodeFlag.next==null)
            {
                return false;
            }else
            {
                nodeFlag.next=nodeFlag.next.next;
            }
        }
        return true;
    }
}


class ListNode{
   public int Value;
    public ListNode next;

    public  ListNode(){
    }
    public  ListNode(int Val){
        this.Value=Val;
}
    public  ListNode(int Val,ListNode next){
        this.Value=Val;
        this.next=next;

    }
}