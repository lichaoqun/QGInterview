// - https://leetcode-cn.com/problems/rotate-image/

class Solution {
    public void rotate1(int[][] matrix) {
        int count = matrix.length;
        int [][]newArray = new int[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                newArray[j][count - i - 1] = matrix[i][j];
            }
        }
    }

    public void rotate(int[][] matrix) {
        int count = matrix.length;
        for (int row = 0; row < count / 2; row++) {
            for (int col = 0; coli < (count + 1) / 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[count - col - 1][row];
                matrix[count- col - 1][row] = matrix[count - row - 1][count - col - 1];
                matrix[count- row - 1][count- col - 1] = matrix[col][count - row - 1];
                matrix[col][count - row - 1] = temp;
            }
            
        }
        
    }

    public static void main(String[] args) {

    }
}