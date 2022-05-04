// - https://leetcode-cn.com/problems/merge-sorted-array/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;
        m--;
        n--;
        while (idx >= 0) {
            while (m >= 0 && ((n < 0) || nums1[m] >= nums2[n])) {
                nums1[idx--] = nums1[m--];
            }

            while (n >= 0 && ((m < 0) || nums2[n] >= nums1[m])) {
                nums1[idx--] = nums2[n--];
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}