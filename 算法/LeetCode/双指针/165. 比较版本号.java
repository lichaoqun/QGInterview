// - https://leetcode-cn.com/problems/compare-version-numbers/
class Solution {
    public int compareVersion(String version1, String version2) {
        int v1Idx = 0;
        int v2Idx = 0;
        int v1Len = version1.length();
        int v2Len = version2.length();
        while (v1Idx < v1Len || v2Idx < v2Len) {
            int v1Val = 0;
            for (; v1Idx < v1Len; v1Idx++) {
                char ch = version1.charAt(v1Idx);
                if (ch == '.') break;
                v1Val = v1Val * 10 + ch - '0';
            }
            v1Idx++;

            int v2Val = 0;
            for (; v2Idx < v2Len; v2Idx++) {
                char ch = version2.charAt(v2Idx);
                if (ch == '.') break;
                v2Val = v2Val * 10 + ch - '0';
            }
            v2Idx++;

            if (v1Val != v2Val) {
                return v1Val > v2Val ? 1 : -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.compareVersion("1.01", "1.001");
    }
}