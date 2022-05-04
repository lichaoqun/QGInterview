// - https://leetcode-cn.com/problems/valid-sudoku/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int [][]rows = new int[9][9];
        int [][]cols = new int[9][9];
        int [][][]subBoxs = new int[3][3][9];


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                int idx = ch - '0' - 1;
                rows[i][idx]++;
                cols[j][idx]++;                
                subBoxs[i/3][j/3][idx]++;
                if (rows[i][idx] > 1|| cols[j][idx] > 1 || subBoxs[i/3][j/3][idx] > 1) {
                    return false;
                }
            }
    
        }
        return true;
    }

    


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValidSudoku(
            new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
            }
        ));
    }
}