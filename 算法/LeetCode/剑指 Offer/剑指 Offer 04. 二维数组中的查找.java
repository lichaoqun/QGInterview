// - https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int clos  = matrix[0].length;
        int row = 0;
        int clo = clos - 1;
        while(row < row && clo >= 0){
            int num = matrix[row][clo];
            if (num == target) return true;
            if (num > target) {
                clo--;
                continue;   
            }
            row++;
        }
        return false;
    }
}