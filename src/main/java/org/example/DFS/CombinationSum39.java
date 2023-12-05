package org.example.DFS;

import java.util.*;

public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //Add(result,candidates,target,0,new ArrayList<>());
//        for (int i = 0; i < candidates.length; i++) {
//            Integer flag = 0;
//            List<Integer> resultItem = new ArrayList<>();
//            flag += candidates[i];
//
//            if (flag == target) {
//                resultItem.add(candidates[i]);
//                Collections.sort(resultItem);
//                result.add(resultItem);
//                continue;
//            } else if (flag < target) {
//                Add(result, candidates, target, flag, resultItem);
//            } else {
//                flag -= candidates[i];
//                //break;
//            }
//        }
        for (int i = 0; i < candidates.length; i++) {
            Add(result,candidates,target,0,new ArrayList<>(),candidates[i]);
        }
        return result;
    }

    public void Add(List<List<Integer>> result, int[] candidates, int target, int flag, List<Integer> ResultItem, int candidate) {

        List<Integer> resultItem = new ArrayList<>();
        for (Integer n : ResultItem
        ) {
            resultItem.add(n);
        }

        if (flag + candidate == target) {
            ResultItem.add(candidate);
            Collections.sort(ResultItem);
            if (!result.contains(ResultItem))
                result.add(ResultItem);
        }else {
            int flagTemp = flag;
            flagTemp += candidate;
            resultItem.add(candidate);
            for (int i = 0; i < candidates.length; i++) {
                Add(result, candidates, target, flagTemp, resultItem, candidates[i]);
            }
        }


    }

}

