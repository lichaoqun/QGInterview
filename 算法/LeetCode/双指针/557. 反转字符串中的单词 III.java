// - https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/

class Solution {
    public String reverseWords(String s) {
        int leftIdx = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < len; idx++) {
            char ch = s.charAt(idx);
            if (ch == ' ') {
                for (int tempIdx = idx - 1; tempIdx >= leftIdx; tempIdx--) {
                    sb.append(s.charAt(tempIdx));
                }
                sb.append(' ');
                leftIdx = idx + 1;
                continue;
            }
            if (idx == len - 1) {
                for (int tempIdx = idx; tempIdx >= leftIdx; tempIdx--) {
                    sb.append(s.charAt(tempIdx));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("Let's take LeetCode contest"));
    }
}