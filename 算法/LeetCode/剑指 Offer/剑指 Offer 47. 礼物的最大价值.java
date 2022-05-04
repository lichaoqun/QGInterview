// - https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
class Solution {
    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][]dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        int max = dp[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
            max = Math.max(max, dp[i][0]);
        }

        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
            max = Math.max(max, dp[0][i]);
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]) + grid[i][j];
                max = Math.max(max, dp[i][j]);
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(dp[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        return max;
    }
}