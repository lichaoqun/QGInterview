import java.util.ArrayList;
import java.util.List;

// - https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int leftVal = nums[left];
            int rightVal = nums[right];
            int sum = leftVal + rightVal;
            if (sum  == target) return new int[]{nums[left], nums[right]};
            if (sum > target){
                right--;
                continue;
            } 
            left++;
        }
        return new int[0];
    }
}