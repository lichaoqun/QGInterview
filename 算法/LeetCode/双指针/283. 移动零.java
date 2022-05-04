// - https://leetcode-cn.com/problems/move-zeroes/
class Solution {
    public void moveZeroes1(int[] nums) {
        int fastIdx = 0;
        int slowIdx = 0;
        int len = nums.length;
        
        // - 过滤0
        while (fastIdx < len) {
            if (nums[fastIdx] != 0) {
                nums[slowIdx++] = nums[fastIdx];
            }
            fastIdx++;
        }

        // - 填充剩余的0
        while (slowIdx < len) {
            nums[slowIdx++] = 0;
        }
    }

    public void moveZeroes(int[] nums) {
        int leftIdx = 0;
        int rightIdx = 0;
        int len = nums.length;
        while (rightIdx < len) {
            if (nums[rightIdx] != 0) {
                int temp = nums[rightIdx];
                nums[rightIdx] = nums[leftIdx];
                nums[leftIdx++] = temp;
            }
            rightIdx++;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.moveZeroes(new int[]{0,1,0,3,12});
    }
}