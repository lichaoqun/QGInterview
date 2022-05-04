// - https://leetcode-cn.com/problems/implement-strstr/submissions/
class Solution {
    public boolean isHappy(int n) {
        while (n >= 10) {
            int tempVal = n;
            int sum = 0;
            while (tempVal != 0) {
                sum += Math.pow((tempVal % 10), 2);
                tempVal = tempVal / 10;
            }
            n = sum;
        }
        if (n == 1) return true;
        if (n == 7) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isHappy(19);
    }
}