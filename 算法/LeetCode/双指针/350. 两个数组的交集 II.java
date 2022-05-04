import java.util.Arrays;

// - https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int  nums1Idx = 0;
        int  nums2Idx = 0;
        int [] nums = new int[Math.min(nums1Len, nums2Len)];
        int numsIdx = 0;
        while (nums1Idx < nums1Len && nums2Idx < nums2Len) {
            int nums1Val = nums1[nums1Idx];
            int nums2Val = nums2[nums2Idx];
            if (nums1Val > nums2Val) {
                nums2Idx++;
                continue;
            }
            if (nums1Val < nums2Val) {
                nums1Idx++;
                continue;
            }
            nums[numsIdx++] = nums1Val;
            nums1Idx++;
            nums2Idx++;
        }

        int [] ans = new int[numsIdx];
        for (int idx = 0; idx < numsIdx; idx++) {
            ans[idx] = nums[idx];
        }

        return ans;
    }
}