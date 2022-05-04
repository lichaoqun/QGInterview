import java.util.Arrays;

// - https://leetcode-cn.com/problems/permutation-in-string/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if(s1Len > s2Len) return false;
        char[] s1Chars = new char[26];
        char[] s2Chars = new char[26];

        for (int idx = 0; idx < s1Len; idx++) {
            s1Chars[(int) (s1.charAt(idx) - 'a')]++;
            s2Chars[(int) (s2.charAt(idx) - 'a')]++;
        }
        if (Arrays.equals(s1Chars, s2Chars)) {
            return true;
        }

        for (int idx = s1Len; idx < s2Len; idx++) {
            s2Chars[(int) (s2.charAt(idx) - 'a')]++;
            s2Chars[(int) (s2.charAt(idx - s1Len) - 'a')]--;
            if (Arrays.equals(s1Chars, s2Chars)) {
                return true;
            }
        }
        return false;
    }
}