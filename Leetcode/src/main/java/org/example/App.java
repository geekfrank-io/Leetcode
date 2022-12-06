package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");


        SOLUTION so = new SOLUTION();
        List<String> result = so.letterCombinations("23");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

    // 电话号码
    static class SOLUTION {

        public List<String> letterCombinations(String digits) {
            HashMap<Integer, String> map = new HashMap<Integer, String>();
            List<String> result = new ArrayList<String>();
            map.put(2, "abc");
            map.put(3, "def");
            map.put(4, "ghi");
            map.put(5, "jkl");
            map.put(6, "mno");
            map.put(7, "pqrs");
            map.put(8, "tuv");
            map.put(9, "wxyz");
            int count = digits.length();
            if (count <= 0) return result;
            Demo(digits, result, map, 1, new String());
            return result;
        }

        private void Demo(String digtis, List<String> result, HashMap map, int layer, String str) {
            int count = digtis.length();
            if (layer > count) return;

            String vals = (String) map.get(Integer.parseInt(digtis.substring(layer - 1, layer)));
            for (int i = 0; i < vals.length(); i++) {
                String sb = str + "";
                sb.concat(vals.substring(i, i + 1));
                if (layer == count) {
                    result.add(sb.toString());
                    //str=new StringBuilder();
                    //return;
                } else {
                    Demo(digtis, result, map, layer + 1, sb);
                }
            }
        }
    }
    // 电话号码
    static class Solution {

        public List<String> letterCombinations(String digits) {
            HashMap<Integer, String> map = new HashMap<Integer, String>();
            List<String> result = new ArrayList<String>();
            map.put(2, "abc");
            map.put(3, "def");
            map.put(4, "ghi");
            map.put(5, "jkl");
            map.put(6, "mno");
            map.put(7, "pqrs");
            map.put(8, "tuv");
            map.put(9, "wxyz");
            int count = digits.length();
            if (count <= 0) return result;
            Demo(digits, result, map, 1, new StringBuilder());
            return result;
        }

        private void Demo(String digtis, List<String> result, HashMap map, int layer, StringBuilder str) {
            int count = digtis.length();
            if (layer > count) return;

            String vals = (String) map.get(Integer.parseInt(digtis.substring(layer - 1, layer)));
            for (int i = 0; i < vals.length(); i++) {
                String s = new String(str.toString());
                StringBuilder sb = new StringBuilder(s);
                sb.append(vals.substring(i, i + 1));
                if (layer == count) {
                    result.add(sb.toString());
                    //str=new StringBuilder();
                    //return;
                } else {
                    Demo(digtis, result, map, layer + 1, sb);
                }
            }
        }
    }
}


