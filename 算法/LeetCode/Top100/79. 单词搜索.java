// - https://leetcode-cn.com/problems/word-search/
class Solution {
    public boolean exist(char[][] board, String word) {
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.exist(new char[][]{
            new char[]{'a'},
            new char[]{'b'}
        }, "abc"));
    }
}