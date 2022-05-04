// - https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[Math.max(4, n + 1)];
        dp[2] = 1;
        dp[3] = 2;
        for(int i = 4; i <= n; i++){
            for(int j = 2; j < (i - 1); j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}