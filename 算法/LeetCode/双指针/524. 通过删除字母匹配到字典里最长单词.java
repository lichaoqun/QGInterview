// - https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        int sLen = s.length();
        for (String subS : dictionary) {
            int sIdx = 0;
            int subSIdx = 0;
            int subSLen = subS.length();
            while (sIdx < sLen && subSIdx < subSLen) {
                if (s.charAt(sIdx) == subS.charAt(subSIdx)) {
                    subSIdx++;
                }
                sIdx++;
            }
            if (subSIdx == subSLen) {
                int ansLen = ans.length();
                if (subSLen > ansLen || subSLen == ansLen && (subS.compareTo(ans) < 0)) {
                    ans = subS;
                }
            }
        }
        return ans;
    }
}
