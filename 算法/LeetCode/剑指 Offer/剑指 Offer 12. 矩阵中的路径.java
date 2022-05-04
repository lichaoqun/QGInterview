// - https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
class Solution {
    public boolean exist(char[][] board, String word) {
            int row = board.length;
            int col= board[0].length;
            char[] words = word.toCharArray();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                   if(dfs(board, i, row, j, col, words, k)) return true;
                }
            }
            return false;
    }
    public boolean dfs(char[][] board, int i, int row, int j, int col, char[] words, int k) {
        if (i >= row || i < 0 || j >= col || j < 0 || words[k] != board[i][j]) {
            return false;
        }
        if (k == words.length - 1) return true;
        board[i][j] = "\0";
        boolean res = (dfs(board, i+1, row, j, col, words, k+1)||
        dfs(board, i-1, row, j, col, words, k+1)||
        dfs(board, i, row, j+1, col, words, k+1)||
        dfs(board, i, row, j-1, col, words, k+1));
        board[i][j] = words[k];
        return res;
    }
}