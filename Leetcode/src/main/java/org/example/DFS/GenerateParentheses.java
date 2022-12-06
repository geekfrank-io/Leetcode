package org.example.DFS;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static  void main(String[] args){
        List<String> strs=Solution.generateParenthesis(2);
        for (String str:strs) {
            System.out.print(str);
        }
    }


}
class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        if(n==0) return  res;
        dfs(n, n, res, "");
        return res;
    }

    private static void dfs(int left,int right, List<String>res,String str)
    {
        if(left>right) return;

        if(left==0&&right==0)
        {
            res.add(str);
            return;
        }
        if(left>0)
        {
            dfs(left-1, right, res, str+"(");
        }
        if(right>0)
        {
            dfs(left, right-1, res, str+")");
        }

    }
}
