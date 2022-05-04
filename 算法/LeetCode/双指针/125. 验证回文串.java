// - https://leetcode-cn.com/problems/valid-palindrome/
class Solution {
    public boolean isPalindrome(String s) {
        char[]charArray = s.toCharArray();
        int len = s.length();
        int fastIdx = 0;
        int slowIndx = 0;
        int x = Math.abs((int)('a' - 'A'));
        while (fastIdx < len) {
            if ((charArray[fastIdx] >= 'a' &&  charArray[fastIdx] <= 'z') || charArray[fastIdx] >= '0' &&  charArray[fastIdx] <= '9') {
                charArray[slowIndx++] = charArray[fastIdx];
            }else if(charArray[fastIdx] >= 'A' &&  charArray[fastIdx] <= 'Z'){
                charArray[slowIndx++] = (char)(charArray[fastIdx] + x);
            }
            fastIdx++;
        }
        int leftIdx = 0;
        int rightIdx = slowIndx - 1;
        while (leftIdx < rightIdx) {
            if (charArray[leftIdx] != charArray[rightIdx]) {
                return false;
            }
            leftIdx++;
            rightIdx--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isPalindrome("0P");
    }
}