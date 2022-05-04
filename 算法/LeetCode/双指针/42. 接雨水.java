// - https://leetcode-cn.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int leftIdx = 0;
        int rightIdx = height.length - 1;
        int leftMaxHei = height[leftIdx];
        int rightMaxHei = height[rightIdx];
        while (leftIdx < rightIdx) {
            int leftCurHei = height[leftIdx];
            int rightCurHei = height[rightIdx];
            leftMaxHei = Math.max(leftMaxHei, leftCurHei);
            rightMaxHei = Math.max(rightMaxHei, rightCurHei);
            if (leftMaxHei < rightMaxHei) {
                ans += leftMaxHei - leftCurHei;
                leftIdx++;
                continue;
            }

            ans += rightMaxHei - rightCurHei;
            rightIdx--;
        }
        return ans;
    }
}