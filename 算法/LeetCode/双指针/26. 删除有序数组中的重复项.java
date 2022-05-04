// - https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
class Solution {
    public int removeDuplicates(int[] nums) {
        int slowIdx = 0;
        int fastIdx = 1;
        int len = nums.length;
        while (fastIdx < len) {
            if (nums[slowIdx] != nums[fastIdx]) {
                nums[++slowIdx] = nums[fastIdx];
            }
            fastIdx++;
        }
        return slowIdx + 1;
    }

    public int removeDuplicates1(int[] nums) {
        int len = nums.length;
        if(len < 2) return len;
        int val = nums[0];
        int ans = 1;
        for (int idx = 1; idx < len; idx++){
            int curVal = nums[idx];
            if (curVal != val) {
                val = curVal;
                nums[ans++] = curVal;
            }
        }
        return ans;
    }
}
