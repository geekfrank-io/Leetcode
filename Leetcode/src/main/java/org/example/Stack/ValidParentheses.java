package org.example.Stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args)
    {

    }

    class Solution {
        HashMap<Character, Character> dic = new HashMap<Character, Character>() {
        };

        public boolean isValid(String s) {
            dic.put('(', ')');
            dic.put('[', ']');
            dic.put('{', '}');
            char[] parms = s.toCharArray();
            Stack stack = new Stack<Character>();
            if (parms.length % 2 != 0)
                return false;
            for (int i = 0; i < parms.length; i++) {
                char c = parms[i];
                if (dic.containsKey(c)) {
                    stack.push(c);
                } else {

                    if (!stack.empty()) {
                        char cc = (char)stack.pop();
                        if ( dic.get(cc)==null||dic.get(cc)!=c) {
                            stack.push(cc);
                            stack.push(c);
                        }
                    }else{
                        stack.push(c);
                    }

                }
            }
            return stack.isEmpty();
        }
    }
}
