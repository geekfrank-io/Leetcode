package org.example.BinarySearch;

public class DevideTwoIntegers29 {
    public static void main(String[] args)
    {
        Solution solution=new Solution();
        int result=solution.divide(-2147483648,-1);
        System.out.print(result);
    }
}
class Solution {
    public int divide(int dividend, int divisor) {

        int flag = 0;
        boolean temp = false;

        if (dividend < 0) {
            temp = !temp;
            dividend = -dividend;
        }
        if (divisor < 0) {
            temp = !temp;
            divisor = -divisor;
        }

        while (dividend >= divisor) {
            dividend -= divisor;
            flag++;
        }
        return temp ? -flag : flag;
    }
}