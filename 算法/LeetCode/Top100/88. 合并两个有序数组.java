// - https://leetcode-cn.com/problems/merge-sorted-array/
class Solution {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        // - 两个数组的空判断
        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        // - 结果数组
        int[] ans = new int[m + n];
        int idx = 0;
        int num1Idx = 0, num2Idx = 0;
        while (num1Idx < m || num2Idx < n) {

            // - 循环对比num1和num2的元素
            while (num1Idx < m && (num2Idx >= n || nums1[num1Idx] <= nums2[num2Idx])) {
                ans[idx++] = nums1[num1Idx++];
            }

            // - 循环对比num1和num2的元素
            while (num2Idx < n && (num1Idx >= m || nums2[num2Idx] <= nums1[num1Idx])) {
                ans[idx++] = nums2[num2Idx++];
            }
        }

        // - 将ans保存到nums1中
        for (int i = 0; i < ans.length; i++) {
            nums1[i] = ans[i];
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // - 合并
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        
        // - 冒泡排序
        for (int end = nums1.length - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 1; begin <= end; begin++) {
                int cur = nums1[begin];
                int prev = nums1[begin - 1];
                if (cur < prev) {
                    nums1[begin] = prev;
                    nums1[begin - 1] = cur;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
        System.out.println("x");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    s.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2, 5, 6}, 3);
    }
}