// - https://leetcode-cn.com/problems/implement-strstr/
class Solution {
    public int strStr1(String haystack, String needle) {
        int needleLen = needle.length();
        if (needleLen == 0) return 0;

        int haystackLen = haystack.length();
        for (int haystackIdx = 0; haystackIdx < haystackLen; haystackIdx++) {
            if (haystackIdx + needleLen > haystackLen) return -1;
            int needleIdx = 0;
            char needleCh = needle.charAt(needleIdx);
            char haystackCh = haystack.charAt(haystackIdx);
            while (haystackCh == needleCh && needleIdx < needleLen - 1) {
                needleCh = needle.charAt(++needleIdx);
                haystackCh = haystack.charAt(haystackIdx + needleIdx);    
           }
           if (needleCh == haystackCh && needleIdx == (needleLen - 1)) {
             return haystackIdx;
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        int needleLen = needle.length();
        if (needleLen == 0) return 0;

        int haystackLen = haystack.length();
        for (int haystackIdx = 0; haystackIdx < haystackLen; haystackIdx++) {
            int needleIdx = 0;
            char needleCh = needle.charAt(needleIdx);
            char haystackCh = haystack.charAt(haystackIdx);
            if (needleCh == haystackCh) {
                for (int idx = 1; idx < needleLen && haystackIdx + idx < haystackLen; needleIdx = idx++) {
                    needleCh = needle.charAt(idx);
                    haystackCh = haystack.charAt(haystackIdx + idx);
                    if(needleCh != haystackCh) break;
                }

                // - 防止 needleLen == 1的情况, 无法进入for循环导致判断的失误
                if (needleIdx == needleLen - 1) return haystackIdx;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.strStr("hello","ll");
        // s.strStr("c","c");
    }
}