// - https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
class Solution {
    public int longestSubstring(String s, int k) {
        int len = s.length(), ans = 0;
        for (int chCount = 1; chCount <= 26; chCount++) {
            int[] chArray = new int[26];
            int left = 0, right = 0;
            int less = 0, totalChCount = 0;
            while (right < len) {
                int lastChIdx = s.charAt(right++) - 'a';
                int lastChCount = ++chArray[lastChIdx];
                if (lastChCount == k) {
                    less--;
                }
                if (lastChCount == 1) {
                    less++;
                    totalChCount++;
                }
                while (totalChCount > chCount) {
                    int firstChIdx = s.charAt(left++) - 'a';
                    int firstChCount = --chArray[firstChIdx];
                    if (firstChCount == k - 1) {
                        less++;
                    }
                    if (firstChCount == 0) {
                        less--;
                        totalChCount--;
                    }
                }
                if (less == 0) {
                    ans = Math.max(ans, right - left);
                }
            }
        }
        return ans;
    }
}