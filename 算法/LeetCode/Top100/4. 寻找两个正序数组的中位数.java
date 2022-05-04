import javax.xml.xpath.XPathFunctionException;

// - https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
class Solution {
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int numsLen = nums1Len + nums2Len;
        int [] nums = new int [numsLen];

        int nums1Idx = 0;
        int nums2Idx = 0;
        int numsIdx = 0;
        while (nums1Idx < nums1Len || nums2Idx < nums2Len) {
            while (nums1Idx < nums1Len && ((nums2Idx >= nums2Len) || (nums1[nums1Idx] <= nums2[nums2Idx]))) {
                nums[numsIdx++] = nums1[nums1Idx++];
            }
            while (nums2Idx < nums2Len && ((nums1Idx >= nums1Len) || (nums1[nums1Idx] >= nums2[nums2Idx]))) {
                nums[numsIdx++] = nums2[nums2Idx++];
            }
        }

        int ansIdx = numsLen >> 1;
        double ans = nums[ansIdx];

        // - 数组长度是奇数个
        if ((numsLen & 1) != 0) {
            return ans;
        }

        // - 数组长度是偶数个
        return (nums[ansIdx - 1] + ans) / 2.0;
    }

    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int len = nums1Len + nums2Len;
        int nums1Idx = 0;
        int nums2Idx = 0;
        int curIdx = 0;
        int left = 0;
        int right = 0;


        // - 中位数下标
        int ansIdx = len >> 1;
        while (curIdx <= ansIdx) {
            while (curIdx <= ansIdx && nums1Idx < nums1Len && ((nums2Idx >= nums2Len) || (nums1[nums1Idx] <= nums2[nums2Idx]))) {
                left = right;
                right = nums1[nums1Idx++];
                curIdx++;
            }
            while (curIdx <= ansIdx && nums2Idx < nums2Len && ((nums1Idx >= nums1Len) || (nums1[nums1Idx] >= nums2[nums2Idx]))) {
                left = right;
                right = nums2[nums2Idx++];
                curIdx++;
            }
        }

        // - 数组长度是奇数个
        if ((len & 1) != 0) {
            return right;
        }

        // - 数组长度是偶数个
        return (left + right) / 2.0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays3(new int []{0, 0}, new int []{0, 0}));
        System.out.println(s.findMedianSortedArrays(new int []{1, 2}, new int []{3, 4})); 
        System.out.println(s.findMedianSortedArrays(new int []{0, 0}, new int []{0, 0}));
        System.out.println(s.findMedianSortedArrays(new int []{}, new int []{1}));
        System.out.println(s.findMedianSortedArrays(new int []{2}, new int []{}));
        System.out.println(s.findMedianSortedArrays(new int []{}, new int []{}));

    }
}