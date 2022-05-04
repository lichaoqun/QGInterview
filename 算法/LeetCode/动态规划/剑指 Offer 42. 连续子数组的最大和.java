// - https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}