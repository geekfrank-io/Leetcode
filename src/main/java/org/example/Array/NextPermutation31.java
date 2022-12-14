package org.example.Array;

public class NextPermutation31 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        printArray(nums);
        Solution solution = new Solution();
        solution.nextPermutation(nums);
        printArray(nums);
    }
    public static void printArray(int[] nums)
    {
        for (int i:nums
             ) {
            System.out.print(i);
        }
        System.out.println("");
    }
    static class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            int m = 0, n = 0;
            if (len <= 0) return;
            for (m = len - 2; m >= 0; m--) {
                if (nums[m] < nums[m + 1]) {
                    break;
                }
            }
            if (m == -1) {
                reverse(nums, 0, len - 1);
                return;
            }
            for (n = len - 1; n >= 0; n--) {
                if (nums[n] > nums[m]) {
                    swap(nums, m, n);
                    break;
                }
            }

            reverse(nums, m + 1, len - 1);
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int[] nums, int i, int j) {
            if (j - i <= 0) return;
            int differ = (j - i) / 2;

            for (int k = 0; k <= differ; k++) {
                swap(nums, i + k, j - k);
            }
        }

    }

}
