// - https://leetcode-cn.com/problems/replace-the-substring-for-balanced-string/

class Solution {
    public int balancedString(String s) {
        // - 本题只需要窗口外每种字符的数目小于等于平均值即可, 因为如果窗口外的小，那么可以将窗口内的补成缺少的字符，达到平均值。如果窗口外的某个字符大于平均值，那个多出来的字符需要被替换成其他字符，这样仅仅将窗口内的字符替换是达不到要求的
        int[] charsArray = new int[26];
        int len = s.length();
        for (int idx = 0; idx < len; idx++) {
            charsArray[s.charAt(idx) - 'A']++;
        }

        int left = 0, right = 0;
        int ans = len;
        int average = len / 4;
        while (right < len) {
            charsArray[s.charAt(right++) - 'A']--;
            while (left < len && charsArray['Q' - 'A'] <= average && charsArray['W' - 'A'] <= average && charsArray['E' - 'A'] <= average && charsArray['R' - 'A'] <= average) {
                ans = Math.min(ans, right - left);
                charsArray[s.charAt(left++) - 'A']++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.balancedString("QWER");
    }
}