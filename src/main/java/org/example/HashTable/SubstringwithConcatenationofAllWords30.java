package org.example.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedTransferQueue;

public class SubstringwithConcatenationofAllWords30 {

    public  static void main(String[] args)
    {
        String s="wordgoodbestgoodwordgoodbestword";
        String [] words=new String[]{"word","good","best"};
       List<Integer> res= Solution.findSubstring(s,words);
       System.out.println(res);
    }


    public static class Solution{
        public static  List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<Integer>();
            int m = words.length,n=words[0].length(),ls=s.length();
            for(int i=0;i<n;i++)
            {
                if (i+m*n>ls) break;
                HashMap<String, Integer> differ=new HashMap<String, Integer>();

                for (int j=0;j<m;j++)
                {
                    String str=s.substring(i+n*j,i+(j+1)*n);
                    differ.put(str,differ.getOrDefault(str,0)+1);
                }
                for (String str: words)
                {
                    differ.put(str,differ.getOrDefault(str,0)-1);
                    if (differ.get(str)==0)
                    {
                        differ.remove(str);
                    }

                }
                for (int start = i; start < ls - m * n + 1; start += n) {
                    if (start != i) {
                        String word = s.substring(start + (m - 1) * n, start + m * n);
                        differ.put(word, differ.getOrDefault(word, 0) + 1);
                        if (differ.get(word) == 0) {
                            differ.remove(word);
                        }
                        word = s.substring(start - n, start);
                        differ.put(word, differ.getOrDefault(word, 0) - 1);
                        if (differ.get(word) == 0) {
                            differ.remove(word);
                        }
                    }
                    if (differ.isEmpty()) {
                        result.add(start);
                    }
                }
            }

            return result;
        }
    }
}

