// - https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
class Solution {
    public int findLength1(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int ans = 0;
        for (int nums1Idx = 0; nums1Idx < nums1Len; nums1Idx++) {
            for (int nums2Idx = 0; nums2Idx < nums2Len; nums2Idx++) {
                int idx1 = nums1Idx;
                int idx2 = nums2Idx;
                while (idx1 < nums1Len && idx2 < nums2Len && nums1[idx1] == nums2[idx2]) {
                    idx1++;
                    idx2++;
                }
                ans = Math.max(ans, idx1 - nums1Idx);
            }
        }
        return ans;
    }

    public int findLength1(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int ans = 0;
        for (int nums1Idx = 0; nums1Idx < nums1Len; nums1Idx++) {
            for (int nums2Idx = 0; nums2Idx < nums2Len; nums2Idx++) {
                int idx = 0;
                while (nums1Idx + idx < nums1Len && nums2Idx + idx < nums2Len && nums1[nums1Idx + idx] == nums2[nums2Idx + idx]) {
                    idx++;
                }
                ans = Math.max(ans, idx);
            }
        }
        return ans;
    }

    public int findLength(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length, nums2Len = nums2.length;
        int ans = 0;
        for (int idx = 0; idx < nums1Len; idx++) {
            int len = Math.min(nums1Len - idx, nums2Len);
            ans = Math.max(ans, maxLength(nums1, nums2, idx, 0, len));
        }
        for (int idx = 0; idx < nums2Len; idx++) {
            int  len = Math.min(nums1Len, nums2Len - idx);
            ans = Math.max(ans, maxLength(nums1, nums2, 0, idx, len));
        }
        return ans;
    }

    public int maxLength(int[] nums1, int[] nums2, int nums1StartIdx, int nums2StartIdx, int len) {
        int ans = 0, curCount = 0;
        for (int idx = 0; idx < len; idx++) {
            if (nums1[nums1StartIdx + idx] == nums2[nums2StartIdx + idx]) {
                ans = Math.max(ans, ++curCount);
                continue;
            }
            curCount = 0;
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.findLength(new int []{0,0,0,0,0,0,1,0,0,0}, new int []{0,0,0,0,0,0,0,1,0,0});
    }
}