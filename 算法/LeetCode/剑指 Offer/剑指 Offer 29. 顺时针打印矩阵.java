import javax.print.attribute.standard.RequestingUserName;

// - https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int left = 0, top = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] ans = new int[rows * cols];
        int bottom = rows - 1;
        int right = cols - 1;
        int idx = 0;
         while (true) {
            for (int i = left; i <= right; i++) {
                ans[idx++] = matrix[top][i];
            }
            top++;
            if(idx == ans.length) break;

            for (int i = top; i <= bottom; i++) {
                ans[idx++] = matrix[i][right];
            }
            right--;
           if(idx == ans.length) break;

            for (int i = right; i >= left; i--) {
                ans[idx++] = matrix[bottom][i];
            }
            bottom--;
            if(idx == ans.length) break;

            for (int i = bottom; i >= top; i--) {
                ans[idx++] = matrix[i][left];
            }
            left++;
            if(idx == ans.length) break;
        }
        return ans;
    }   
}