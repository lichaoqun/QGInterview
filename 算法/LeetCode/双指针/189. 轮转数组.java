// - https://leetcode-cn.com/problems/rotate-array/

class Solution {
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        while (k > 0) {
            int lastVal = nums[len - 1];
            for (int idx = len - 1; idx > 0; idx--) {
                nums[idx] = nums[idx - 1];
            }
            nums[0] = lastVal;
            k--;
        }
        System.out.println();
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        int []tempNums = new int[k];
        for (int idx = len - 1, tempIdx = k - 1; idx >= 0; idx--,tempIdx--) {
            if(tempIdx >= 0){
                tempNums[tempIdx] = nums[idx];
                continue;
            }
            nums[idx + k] = nums[idx];
        }
        
        for (int idx = 0; idx < k; idx++) {
            nums[idx] = tempNums[idx];
        }
    }

    public void rotate3(int[] nums, int k) {
        int len = nums.length;
        int rightIdx = len - 1;
        k %= len;
        reverse(nums, 0, rightIdx);
        reverse(nums, 0, k - 1);
        reverse(nums, k, rightIdx);
    }
    public void reverse(int[] nums, int begin , int end) {
        while (begin < end) {
            int val = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = val;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.rotate(new int []{1,2,3,4,5,6,7}, 3);
    }
}