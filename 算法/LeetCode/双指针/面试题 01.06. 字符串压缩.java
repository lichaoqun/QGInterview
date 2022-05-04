// - https://leetcode-cn.com/problems/compress-string-lcci/
class Solution {
    public String compressString1(String S) {
        int fastIdx = 1;
        int slowIdx = 0;
        int len = S.length();
        if(len < 2) return S;
        StringBuffer compressedString = new StringBuffer();
        while(fastIdx < len){
            char slowChar = S.charAt(slowIdx);
            char fastChar = S.charAt(fastIdx);
            if (slowChar != fastChar) {
                compressedString.append(slowChar);
                compressedString.append(fastIdx - slowIdx);
                slowIdx = fastIdx;
            }
            fastIdx++;
        }
        compressedString.append(S.charAt(slowIdx));
        compressedString.append(fastIdx - slowIdx);
        return (compressedString.length() >= len) ?  S : compressedString.toString();
    }

    public String compressString(String S) {
        int len = S.length();
        if(len < 2) return S;

        StringBuffer compressedString = new StringBuffer();
        char lastCh = S.charAt(0);
        int lastIdx = 0;
        for (int idx = 0; idx < len; idx++) {
            char curCh = S.charAt(idx);
            if (curCh != lastCh) {
                compressedString.append(lastCh);
                compressedString.append(idx - lastIdx);
                lastCh = curCh;
                lastIdx = idx;
            }
        }
        compressedString.append(lastCh);
        compressedString.append(len - lastIdx);
        return (compressedString.length() >= len) ?  S : compressedString.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.compressString("abbccd");
    }
}