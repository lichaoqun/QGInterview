// - https://leetcode-cn.com/problems/3sum-closest/

import java.util.List;
import java.util.ArrayList;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        
        // - 排序
        for (int end = len - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 0; begin < end; begin++) {
                int curVal = nums[begin];
                int nextIdx = begin + 1;
                int nextVal = nums[nextIdx];
                if (curVal > nextVal) {
                    nums[begin] = nextVal;
                    nums[nextIdx] = curVal;
                    sorted = false;
                }
            }
            if(sorted) break;
        }

        // - 遍历
        int ans = 0;
        int min = Integer.MAX_VALUE;
        int rightIdxConst = len - 1;
        for (int idx = 0; idx < len; idx++) {
            int curVal = nums[idx];
            
            // - 循环过一次之后开始做重复判断
            if (idx > 0 && curVal == nums[idx - 1]) continue;

            int leftIdx = idx + 1;
            int rightIdx = rightIdxConst;
            while (leftIdx < rightIdx) {
                int leftVal = nums[leftIdx];
                int rightVal = nums[rightIdx];
                int sum = curVal + leftVal + rightVal;
                if (sum == target) return target;
                int tempVal = Math.abs(sum - target);
                if (tempVal < min) {
                    min = tempVal;
                    ans = sum;
                }
                if (sum < target) {
                    // - 过滤相同的元素
                    while (leftIdx < rightIdx && nums[leftIdx + 1] == leftVal) leftIdx++;
                    leftIdx++;
                    continue;
                }
                if (sum > target) {
                    // - 过滤相同的元素
                    while (leftIdx < rightIdx && nums[rightIdx - 1] == rightVal) rightIdx--;
                    rightIdx--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.threeSumClosest(new int[] { -1, 0, 1, 2, -1, -4 }, 0);
    }
}