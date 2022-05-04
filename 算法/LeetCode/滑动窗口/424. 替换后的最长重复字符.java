import java.security.KeyFactory;

// - https://leetcode-cn.com/problems/longest-repeating-character-replacement/
class Solution {
    public int characterReplacement(String s, int k) {
        int  len = s.length();
        int left = 0, right = 0;
        int[] charArray = new int[26];
        int ans = 0, maxCount = 0;
        while (right < len) {
            int lastChIdx = (int)(s.charAt(right++) - 'A');
            maxCount = Math.max(maxCount, ++charArray[lastChIdx]);
            while (right - left > maxCount + k) {
                charArray[(int)(s.charAt(left++) - 'A')]--;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}