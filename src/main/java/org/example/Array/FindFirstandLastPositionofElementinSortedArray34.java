package org.example.Array;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray34 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] res=Solution.searchRange(nums, 8);
        System.out.print(Arrays.toString(res));
    }

    static class Solution {
        public static int[] searchRange(int[] nums, int target) {
            int[] res = {-1, -1};
            int len = nums.length;
            if (len == 0) return res;
            if (len == 1) return nums[0] == target ? new int[]{0, 0} : res;
            int left = 0, right = len - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    int l = mid, r = mid;
                    while (0 < l && target == nums[l - 1]) {
                        l--;
                    }
                    while (r < len - 1 && target == nums[r + 1]) {
                        r++;
                    }
                    res[0] = l;
                    res[1] = r;
                    return res;
                }
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return res;
        }
    }
}
