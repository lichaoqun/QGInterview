import java.util.ArrayList;
import java.util.List;

// - https://leetcode-cn.com/problems/spiral-matrix/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List <Integer> result = new ArrayList<Integer>();
        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        while (true) {
            // - 左 -> 右
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            if (++top > bottom) return result;

            // - 上 -> 下
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            if (--right < left) return result;

            // - 右 -> 左
            for (int col = right; col >= left; col--) {
                result.add(matrix[bottom][col]);
            }
            if (--bottom < top) return result;

            // - 下 -> 上
            for (int row = bottom; row >= top; row--) {
                result.add(matrix[row][left]);
            }
            if (++left > right) return result;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(
            s.spiralOrder(new int[][]{
            new int []{1, 2, 3},
            new int []{4, 5, 6},
            new int []{7, 8, 9}
        }));
    }
}