import java.util.Arrays;

// - https://leetcode-cn.com/problems/permutation-in-string/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len > s2Len)  return false;
        int s1CharCountArray [] = new int[26];
        int s2CharCountArray [] = new int[26];
        for (int idx = 0; idx < s1Len; idx++) {
            s1CharCountArray[s1.charAt(idx) - 'a']++;
            s2CharCountArray[s2.charAt(idx) - 'a']++;
        }
        if (Arrays.equals(s1CharCountArray, s2CharCountArray)) {
            return true;
        }

        for (int idx = s1Len; idx < s2Len; idx++) {
            s2CharCountArray[s2.charAt(idx) - 'a']++;
            s2CharCountArray[s2.charAt(idx - s1Len) - 'a']--;
            if (Arrays.equals(s1CharCountArray, s2CharCountArray)) {
                return true;
            }    
        }
        return false;
    }
}