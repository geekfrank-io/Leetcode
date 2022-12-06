package org.example.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum4 {
    public  static void main(String[] args){
        System.out.println("Hello World!");
        Solution solution=new Solution();
        int[] nums=new int[]{0,0,0,1000000000,1000000000,1000000000,1000000000};
        int target=1000000000;
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        result=solution.fourSum(nums,target);
        for (List<Integer> li: result) {
            for (int num: li
                 ) {
                System.out.print(num+"   ");
            }
            System.out.println("");
        }
    }

    /*
     * @lc app=leetcode.cn id=18 lang=java
     *
     * [18] 四数之和
     */

    // @lc code=start
   static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            int count = nums.length;
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if (count < 4)
                return result;
            Arrays.sort(nums);
            for (int i = 0; i < count - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                    break;
                if ((long)nums[i] + nums[count - 1] + nums[count - 2] + nums[count - 3] < target)
                    continue;
                for (int j = i + 1; j < count - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1])
                        continue;
                    if ((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                        break;
                    if ((long)nums[i] + nums[j] + nums[count - 1] + nums[count - 2] < target)
                        continue;
                    int l = j + 1;
                    int r = count - 1;
                    while (l < r) {
                        int sum = nums[i] + nums[j] + nums[l] + nums[r];
                        if (sum == target) {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[l]);
                            list.add(nums[r]);
                            result.add(list);

                            while (l < r && nums[r - 1] == nums[r]) {
                                r--;
                            }
                            r--;

                            while (l < r && nums[l] == nums[l + 1]) {
                                l++;
                            }
                            l++;
                        } else if (sum > target) {
                            r--;

                        } else {
                            l++;

                        }
                    }
                }
            }
            return result;
        }
    }
}
