import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// - https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
class Solution {
    public List<Integer> findAnagrams(String s, String p)  {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> ans = new ArrayList<>();
        if (pLen > sLen) {
            return ans;
        }
        char[] sChars = new char[26];
        char[] pChars = new char[26];
        int idx = 0;
        for (; idx < pLen; idx++) {
            sChars[(int)(s.charAt(idx) - 'a')]++;
            pChars[(int)(p.charAt(idx) - 'a')]++;
        }
        if (Arrays.equals(sChars, pChars)) {
            ans.add(0);
        }
        for (; idx < sLen; idx++) {
            sChars[(int)(s.charAt(idx) - 'a')]++;
            int startIdx = idx - pLen;
            sChars[(int)(s.charAt(startIdx) - 'a')]--;

            if (Arrays.equals(sChars, pChars)) {
                ans.add(startIdx + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findAnagrams("cbaebabacd", "abc");
    }
}