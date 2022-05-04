// - https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[] {searchIdx(nums, target, true), searchIdx(nums, target, false)};
        return range;
    }

    public int searchIdx(int[] nums, int target, boolean searchFirst) {
        int len = nums.length;
        int begin = 0;
        int end = len - 1;
        int res = -1;
        while (begin <= end) {
            int mid = (begin + end) >> 1;
            if (target == nums[mid]) {
                res = mid;
                if (searchFirst) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
                continue;
            }
            if (target > nums[mid]) {
                begin = mid + 1;
                continue;
            }
            end = mid - 1;
        }
        return res;
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            // - 第一个大于目标的数字
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right  = mid - 1;
                ans = mid;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] result = s.searchRange(new int []{5,7,7,8,8,10}, 8);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        } 
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}