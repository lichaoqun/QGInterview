// - https://leetcode-cn.com/problems/intersection-of-two-arrays/
import java.util.Arrays;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int num1Len = nums1.length;
        int num2Len = nums2.length;
        int minLen = Math.min(num1Len, num2Len);
        int num1Idx = 0;
        int num2Idx = 0;
        int idx = 0;
        int []nums = new int[minLen];
        int lastVal = Integer.MIN_VALUE;
        while (num1Idx < num1Len && num2Idx < num2Len) {
            int num1Val = nums1[num1Idx];
            int num2Val = nums2[num2Idx];

            if (num1Val < num2Val) {
                num1Idx++;
                continue;
            }
            if (num1Val > num2Val) {
                num2Idx++;
                continue;
            }
            num1Idx++;
            num2Idx++;
            if(lastVal != num1Val){
                nums[idx++] = num1Val;
                lastVal = num1Val;
            }
        }
        return Arrays.copyOfRange(nums, 0, idx);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] c = s.intersection(new int[]{1,2,2,1}, new int[]{2,2});
        System.out.println();
    }
}