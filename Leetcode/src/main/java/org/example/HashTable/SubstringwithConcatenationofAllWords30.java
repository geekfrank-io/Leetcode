package org.example.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedTransferQueue;

public class SubstringwithConcatenationofAllWords30 {

    public  static void main(String[] args)
    {
        String s="wordgoodgoodgoodbestword";
        String [] words=new String[]{"word","good","best","word"};
        Solution.findSubstring(s,words);

    }


    public static class Solution{
        public static  List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<Integer>();
            int m = words.length,n=words[0].length(),ls=m*n;
            for (int i=0;i<n;i++)
            {
                Map<String,Integer> map=new HashMap<String,Integer>();
                for(int j=0;j<m;j++)
                {

                }
            }
            return result;
        }
    }

    class SOLUTION {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<Integer>();
            //m:单词个数 n:单个单词长度 ls:字符串长度
            int m = words.length, n = words[0].length(), ls = s.length();
            for (int i = 0; i < n; i++) {
                if (i + m * n > ls) {
                    break;
                }
                Map<String, Integer> differ = new HashMap<String, Integer>();
                for (int j = 0; j < m; j++) {
                    //从i处截取单词，一共截取m个并进行统计
                    String word = s.substring(i + j * n, i + (j + 1) * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                }
                for (String word : words) {
                    //遍历数组中给定的单词，出现过的个数-1，为零时删除
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
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
                        res.add(start);
                    }
                }
            }
            return res;
        }
    }
}

