package org.example.Array;

import java.util.List;

public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] param = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 6, 6};
        int result = solution.removeDuplicates(param);
        System.out.println(result);
    }

}

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int flag = 1;

        while (i < nums.length && flag < nums.length) {

            if (nums[i] <= nums[i - 1]) {
                while (flag < (nums.length - 1) && nums[flag] == nums[++flag]) {
                    //flag++;
                }
                if (flag<nums.length) nums[i] = nums[flag];
                i++;


            }
//            else {
//                i++;
//            }
        }
        return i;

    }
}

