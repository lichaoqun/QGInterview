// - https://leetcode-cn.com/problems/chou-shu-lcof/
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int [n + 1];
        dp[1] = 1;
        int n2 = 1, n3 = 1, n5 = 1;
        for (int i = 2; i <= n; i++) {
            int a2 = dp[n2] * 2;
            int a3 = dp[n3] * 3;
            int a5 = dp[n5] * 5;
            dp[i] = Math.min(Math.min(a2, a3), a5);
            if (dp[i] == a2) n2++;
            if (dp[i] == a3) n3++;
            if (dp[i] == a5) n5++;
        }
        return dp[n];
    }
}