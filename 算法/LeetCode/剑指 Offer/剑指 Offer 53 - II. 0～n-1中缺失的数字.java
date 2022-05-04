// - https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
class Solution {
        public int missingNumber(int[] nums) {
        int left = 0; int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2.0;
            if (nums[mid] == mid) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            return left;
        }
    }
}