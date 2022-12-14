package org.example.Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LongestValidParentheses32 {
    public static void main(String[] args)
    {

    }
}

class Solution{
    public int longestValidParentheses(String s) {



        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        int flag=0;
        for (int i=0;i<s.length();i++)
        {
            char p=s.charAt(i);
            if (p=='(')
            {
                stack.push(i);
            }else
            {
                stack.pop();
                if (stack.isEmpty())
                {
                    stack.push(i);
                }else
                {
                    flag=Math.max(flag,i-stack.peek());
                }
            }

        }
        return flag;
    }
}
