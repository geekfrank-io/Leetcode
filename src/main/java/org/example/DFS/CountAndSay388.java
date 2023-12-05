package org.example.DFS;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay388 {
    public class Solution {
        public String countAndSay(int n) {
            String str="1";
            for (int i=0;i<n;i++){
                str=Say(str);
            }
            return str;
        }
        
        public String Say(String Str)
        {
            List<int[]> ListCount=new ArrayList<int[]>();
            char ccc='.';
            for (int i=0;i<Str.length();i++)
            {
                char c=Str.charAt(i);
                if (c!=ccc){
                    int val=c-'0';
                    ListCount.add(new int[]{val,1});
                    ccc=c;
                }else
                {
                   int count= ListCount.get(ListCount.size()-1)[1];
                    ListCount.get(ListCount.size()-1)[1]=count+1;
                }
            }
           String  str="";
            for (int[] item: ListCount
                 ) {
                int digital=item[0];
                int count=item[1];
                str+=count+""+digital;
            }
            
            return str;
        }
    }

}

