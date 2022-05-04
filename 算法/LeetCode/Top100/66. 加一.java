import java.util.ArrayList;
import java.util.List;

// - https://leetcode-cn.com/problems/plus-one/


class Solution {
    public int[] plusOne1(int[] digits) {
        int len = digits.length;
        int[]result = new int [len + 1];
        int temp = 1;
        for (int i = len - 1; i >= 0; i--) {
            int val = digits[i];
            result[i + 1] = (val + temp) % 10;
            temp = (val + temp) / 10;
        }

        // -  位数变化
        if (temp != 0) {
            result[0] = temp;
            return result;
        }

        // - 位数没变
        int[]newResult = new int [len];
        for (int i = 1; i <= len; i++) {
            newResult[i - 1] = result[i];
        }

        return newResult;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int []array = s.plusOne(new int []{1, 2, 3});
        // int []array = s.plusOne(new int []{4,3,2,1});
        // int []array = s.plusOne(new int []{0});
        // int []array = s.plusOne(new int []{9});
        // int []array = s.plusOne(new int []{9,9});
        // int []array = s.plusOne(new int []{9,9,9});
        for (int i : array) {
            System.out.println(i);
        }
    }
}