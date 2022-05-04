// - https://leetcode-cn.com/problems/jump-game/
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean dp[] = new boolean [len];
        dp[0] = true;
        for (int i = 1; i < len; i++) {
            dp[i] = false;
            for (int j = 0; j < i; j++) {
                if ((dp[j] == true) && (j + nums[j] >= i)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }
}