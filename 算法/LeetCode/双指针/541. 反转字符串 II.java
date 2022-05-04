// - https://leetcode-cn.com/problems/reverse-string-ii/
class Solution {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] charsArray = s.toCharArray();
        for (int idx = 0; idx < len; idx += (2 * k)) {
            int leftIdx = idx;
            int rightIdx = Math.min(idx + k, len) - 1;
            while (leftIdx < rightIdx) {
                char temp = charsArray[leftIdx];
                charsArray[leftIdx] = charsArray[rightIdx];
                charsArray[rightIdx] = temp;
                leftIdx++;
                rightIdx--;
            }
        }
        return new String(charsArray);
    }
}