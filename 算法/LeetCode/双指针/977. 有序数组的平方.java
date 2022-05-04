// - https://leetcode-cn.com/problems/find-median-from-data-stream/solution/
class Solution {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int idx = 0;

        // - 找到第一个非负数出现的位置
        for (; idx < len; idx++) {
            if (nums[idx] >= 0)
                break;
        }

        int[] ans = new int[len];
        int leftEnd = idx - 1;
        int rightBegin = idx;
        idx = 0;
        while (idx < len) {
            while (leftEnd >= 0) {
                int val = (int) Math.pow(nums[leftEnd], 2);
                if (rightBegin < len && val > Math.pow(nums[rightBegin], 2))
                    break;

                ans[idx++] = val;
                leftEnd--;
            }
            while (rightBegin < len) {
                int val = (int)Math.pow(nums[rightBegin], 2);
                if (leftEnd >=0 && val > Math.pow(nums[leftEnd], 2)) break;
                ans[idx++] = val;
                rightBegin++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.sortedSquares(new int[] { -4, -1, 0, 3, 10 });
    }
}