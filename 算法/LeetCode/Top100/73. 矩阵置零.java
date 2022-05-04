// - https://leetcode-cn.com/problems/sqrtx/

class Solution {
    public void setZeroes(int[][] matrix) {
        
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int idxs[][] = new int[rowCount][colCount];

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.print('\n');
        }

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if (matrix[row][col] == 0) {
                    idxs[row][col] = 1;                   
                }
            }
        }

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if (matrix[row][col] == 0 && idxs[row][col] == 1) {
                    setZeroes(matrix, row, col);                 
                }
            }
        }

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.print('\n');
        }

    }

    public void setZeroes(int[][] matrix, int rowIdx, int colIdx) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if (row == rowIdx || col == colIdx) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.setZeroes(new int[][]{
            new int []{1, 1, 1},
            new int []{1, 0, 1},
            new int []{1, 1, 1},
        });

        s.setZeroes(new int[][]{
            new int []{0, 1, 2, 0},
            new int []{3, 4, 5, 2},
            new int []{1, 3, 1, 5},
        });
    }
}