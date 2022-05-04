// - https://leetcode-cn.com/problems/valid-triangle-number/
class Solution {
    public int triangleNumber(int[] nums) {
        int len = nums.length;
        
        // - 排序
        for (int end = len - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 0; begin < end; begin++) {
                int nextIdx = begin + 1;
                int curVal = nums[begin];
                int nextVal = nums[nextIdx];
                if (curVal > nextVal) {
                    nums[begin] = nextVal;
                    nums[nextIdx] = curVal;
                    sorted = false;
                }
            }
            if (sorted) break;
        }

        int ans = 0;
        for (int idx = 0; idx < len - 2; idx++) {
            int rightIdxMax = len - 1;
            for (int leftIdx = idx + 1; leftIdx < rightIdxMax; leftIdx++) {
                int rightIdx = rightIdxMax;
                while(leftIdx < rightIdx){
                    if (nums[idx] + nums[leftIdx] > nums[rightIdx]) {
                        ans++;
                    }
                    rightIdx--;
                }
            }
        }
        return ans;
    }

    public int triangleNumber(int[] nums) {
        int len = nums.length;
        
        // - 排序
        for (int end = len - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 0; begin < end; begin++) {
                int nextIdx = begin + 1;
                int curVal = nums[begin];
                int nextVal = nums[nextIdx];
                if (curVal > nextVal) {
                    nums[begin] = nextVal;
                    nums[nextIdx] = curVal;
                    sorted = false;
                }
            }
            if (sorted) break;
        }

        int ans = 0;
        for (int idx = 0; idx < len - 2; idx++) {
            for (int leftIdx = idx + 1; leftIdx < len - 1; leftIdx++) {
                for (int rightIdx = leftIdx + 1; rightIdx < len; rightIdx++) {
                    if (nums[idx] + nums[leftIdx] <= nums[rightIdx]) {
                        break;
                    }
                    ans++;
                }
            }
        }
        return ans;
    }
}