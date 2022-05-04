// - https://leetcode-cn.com/problems/implement-strstr/

class Solution {
    public int strStr1(String haystack, String needle) {
        int nLen = needle.length();
        if (nLen == 0)  return 0;
        int hLen = haystack.length();

        for (int index = 0; index < hLen; index++) {
            int hIdx = index;
            int nIdx = 0;
            while (nIdx < nLen && hIdx < hLen && haystack.charAt(hIdx) == needle.charAt(nIdx)) {
                hIdx++;
                nIdx++;
            }
            if(nIdx == nLen) return index;
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        int nLen = needle.length();
        if (nLen == 0)  return 0;
        int hLen = haystack.length();

        for (int idx = 0; idx + nLen <= hLen; idx++) {
            int nIdx = 0;
            for (int hIdx = 0;nIdx < nLen && haystack.charAt(hIdx + idx) == needle.charAt(nIdx); nIdx++, hIdx++) {
                
            }
            if(nIdx == nLen) return idx;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("hello", "ll"));
        System.out.println(s.strStr("aaaaa", "bba"));
        System.out.println(s.strStr("", ""));
    }
}