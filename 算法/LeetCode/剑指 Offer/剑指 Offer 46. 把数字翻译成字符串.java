// - https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
class Solution {
    public int translateNum(int num) {
        if (num < 10) return 1;
        char[] nums = String.valueOf(num).toCharArray();
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        dp[1] = 1;
        if (nums[0] == '1' || (nums[0] == '2' && nums[1] <= '5')) {
            dp[1] = 2;
            System.out.println("abc");
        }
        for (int i = 2; i < len; i++) {
            int curVal = nums[i];
            int preVal = nums[i - 1];
            if (preVal == '1' || (preVal == '2' && curVal <= '5')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[len-1];
    }
}