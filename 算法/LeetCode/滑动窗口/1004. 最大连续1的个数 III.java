// - https://leetcode-cn.com/problems/max-consecutive-ones-iii/
class Solution {
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        int zeroCount = 0;
        int left = 0, right = 0;
        int ans = 0;
        while (right < len) {
            if (nums[right++] == 0) {
                zeroCount++;
                while (zeroCount > k) {
                    if (nums[left++] == 0) {
                        zeroCount--;
                    }
                }
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}