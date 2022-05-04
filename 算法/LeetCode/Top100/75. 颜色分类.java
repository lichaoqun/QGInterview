// - https://leetcode-cn.com/problems/sort-colors/
class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        for (int end = len - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 1; begin <= end; begin++) {
                int cur = nums[begin];
                int prev = nums[begin - 1];
                if (prev >= cur) {
                    nums[begin] = prev;
                    nums[begin - 1] = cur;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.sortColors(new int[]{2,0,2,1,1,0});
    }
}