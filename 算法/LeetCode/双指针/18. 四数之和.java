import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.midi.Soundbank;

// - https://leetcode-cn.com/problems/4sum/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // - 排序
        Arrays.sort(nums);

        // - 遍历
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        for (int idx = 0; idx < len - 3; idx++) {
            int curVal = nums[idx];

            // - 循环过一次之后开始做重复判断
            if (target > 0 && curVal > target) return ans;

            if (idx > 0 && curVal == nums[idx - 1]) continue;
            for (int nextIdx = idx + 1; nextIdx < len - 2; nextIdx++) {
                int nextVal = nums[nextIdx];
                if (target > 0 && nextVal > target) break;

                // - 循环过一次之后开始做重复判断
                if (nextIdx > idx + 1 && nextVal == nums[nextIdx - 1]) continue;
                
                int leftIdx = nextIdx + 1;
                int rightIdx = len - 1;
                while (leftIdx < rightIdx) {
                    
                    
                    int leftVal = nums[leftIdx];
                    int rightVal = nums[rightIdx];
                    int sum = curVal + nextVal + leftVal + rightVal;
                    if (sum > target) {
                        rightIdx--;
                        continue;
                    }
                    if (sum < target) {
                        leftIdx++;
                        continue;
                    }
                    List<Integer> l = new ArrayList<>();
                    l.add(curVal);
                    l.add(nextVal);
                    l.add(leftVal);
                    l.add(rightVal);
                    ans.add(l);
                    while(leftIdx < rightIdx && leftVal == nums[leftIdx + 1]) leftIdx++;
                    while(leftIdx < rightIdx && rightVal == nums[rightIdx - 1]) rightIdx--;
                    leftIdx++;
                    rightIdx--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11);
    }
}