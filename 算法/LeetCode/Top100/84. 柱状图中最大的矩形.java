import apple.laf.JRSUIConstants.Widget;

// - https://leetcode-cn.com/problems/largest-rectangle-in-histogram/

class Solution {
    public int largestRectangleArea(int[] heights) {
        // - 双指针
        int len = heights.length;
        int ans = Integer.MIN_VALUE;
        for (int left = 0; left < len; left++) {
            int hei = Integer.MAX_VALUE;
            for (int right = left; right < len; right++) {
                hei = Math.min(hei, heights[right]);
                ans = Math.max(ans, (right - left + 1) * hei);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(s.largestRectangleArea(new int[]{2,4}));
    }
}