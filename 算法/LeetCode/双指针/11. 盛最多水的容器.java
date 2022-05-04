// - https://leetcode-cn.com/problems/container-with-most-water/
class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int leftIdx = 0;
        int rightIdx = height.length - 1;
        while (leftIdx < rightIdx) {
            int width = rightIdx - leftIdx;
            int leftVal = height[leftIdx];
            int rightVal = height[rightIdx];
            if (leftVal < rightVal) {
                ans = Math.max(ans, width * leftVal);
                leftIdx++;
                continue;
            }

            ans = Math.max(ans, width * rightVal);
            rightIdx--;
        }
        return ans;
    }
}