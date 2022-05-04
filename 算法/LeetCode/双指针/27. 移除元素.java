// - https://leetcode-cn.com/problems/remove-element/
class Solution {
    public int removeElement(int[] nums, int val) {
        int fIdx = 0;
        int sIdx = 0;
        int len = nums.length;
        while (fIdx < len) {
            if (nums[fIdx] != val) {
                nums[sIdx++] = nums[fIdx];
            }
            fIdx++;
        }
        return sIdx;
    }

    public int removeElement1(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int curVal = nums[i];
            if (curVal != val) {
                nums[idx++] = curVal;
            }
        }
        return idx;
    }

}
