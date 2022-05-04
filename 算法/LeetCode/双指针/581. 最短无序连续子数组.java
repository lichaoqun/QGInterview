import java.util.Arrays;

// - https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int[] sortedNums = new int[len];
        for (int i = 0; i < len; i++) {
            sortedNums[i] = nums[i];
        }

        Arrays.sort(sortedNums);
        
        int leftIdx = 0;
        int rightIdx = len - 1;
        int begin = -1;
        int end = -1;
        while (leftIdx <= rightIdx && (begin == -1 || end == -1)) {
            if (nums[leftIdx] != sortedNums[leftIdx]) {
                begin = leftIdx;
            } else {
                leftIdx++;
            }
            if (nums[rightIdx] != sortedNums[rightIdx]) {
                end = rightIdx;
            } else {
                rightIdx--;
            }
        }
        if (begin == -1)
            return 0;
        return end - begin + 1;
    }
}