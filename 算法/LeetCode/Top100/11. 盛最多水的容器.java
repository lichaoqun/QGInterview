import javax.xml.xpath.XPathFunctionException;

// - https://leetcode-cn.com/problems/container-with-most-water/
class Solution {
    public int maxArea1(int[] height) {
        int max = 0;
        int len = height.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int hei = Math.min(height[i], height[j]);
                int s = (j - i) * hei;
                max = Math.max(s, max);
            }

        }
        return max;
    }

    /* 双指针,i和j分别指向数组的头和尾 s = w * h;
     * 起始状态, w是最大的, 在两个指针不断靠近的过程中, w在不断减小, 如果想让面积s增大 ,就需要h增大, 而h是由height[i]和height[j]中较小的值决定的.
     * 若向内 移动短板 ，h会变大, s可能变大，因此下个水槽的面积 可能增大 。
     * 若向内 移动长板 ，h会变短, s不变或变小，因此下个水槽的面积 一定变小 
     */
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            if (height[left] < height[right]) {
                ans = Math.max(ans, width * height[left++]);
                continue;
            }
            ans = Math.max(ans, width * height[right--]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        // System.out.println(s.maxArea(new int[] { 1, 1 }));
        // System.out.println(s.maxArea(new int[] { 4, 3, 2, 1, 4 }));
        System.out.println(s.maxArea(new int[] { 2, 4 }));
    }
}