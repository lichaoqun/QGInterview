// - https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
class Solution {
    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) >> 1;
            int val = nums[mid];
            if (val == target) return mid;
            
            // - mid 右边有序
            if (val < nums[end]) {
                if ((val < target) && (target <= nums[end])) {
                    begin = mid + 1;
                    continue;
                }

                end = mid - 1;
                continue;
            }

            // - mid 左边有序
            if (nums[0] <= target && target < nums[mid]) {
                end = mid - 1;
                continue;
            }

            begin = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{1, 3}, 3));
    }
}