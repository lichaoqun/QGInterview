// - https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
        int[]dp=new int[prices.Length];//dp[i]代表第i天可获得的最大利润.
        int min=prices[0];
        for(int i=1;i<prices.Length;i++)
        {
            dp[i]=Math.Max(dp[i-1],prices[i]-min);
            min=Math.Min(min,prices[i]);
        }
        return dp[prices.Length-1];
    }
}