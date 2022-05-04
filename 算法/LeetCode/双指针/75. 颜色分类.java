// - https://leetcode-cn.com/problems/sort-colors/
class Solution {
    public void sortColors1(int[] nums) {
        int len = nums.length;
        for (int end = len - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 0; begin < end; begin++) {
                int nextIdx = begin + 1;
                int beginVal = nums[begin];
                int nextVal = nums[nextIdx];
                if (beginVal > nextVal) {
                    nums[begin] = nextVal;
                    nums[nextIdx] = beginVal;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }
    public void sortColors2(int[] nums) {
        int len = nums.length;
        int idx = 0;
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            if (val == 0) {
                nums[i] = nums[idx];
                nums[idx++] = val;
            }
        }
        for (int i = idx; i < len; i++) {
            int val = nums[i];
            if (val == 1) {
                nums[i] = nums[idx];
                nums[idx++] = val;
            }
        }
    }

    public void sortColors(int[] nums) {
        int len = nums.length;
        
        int leftIdx = 0;
        int rightIdx = len - 1;
        for (int idx = 0; idx <= rightIdx;idx++) {
            int val = nums[idx];
            if (val == 0) {
                nums[idx] = nums[leftIdx];
                nums[leftIdx++] = val;
                continue;
            }
            if (val == 2) {
                nums[idx] = nums[rightIdx];
                nums[rightIdx--] = val;
                idx--;
                continue;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // s.sortColors(new int[]{2,0,2,1,1,0});
        s.sortColors(new int[]{2,0,1});
        s.sortColors(new int[]{1,2,0});
    }
}