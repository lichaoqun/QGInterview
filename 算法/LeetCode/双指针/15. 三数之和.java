// - https://leetcode-cn.com/problems/3sum/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(len < 3) return ans;

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

        // - 遍历比较
        for (int idx = 0; idx < len - 2; idx++) {
            int curVal = nums[idx];
            if(curVal > 0) return ans;
            
            // - 循环过一次之后开始做重复判断
            if(idx > 0 && curVal == nums[idx - 1]) continue; 
            int leftIdx = idx + 1;
            int rightIdx = len - 1;
            while (leftIdx < rightIdx) {
                int leftVal = nums[leftIdx];
                int rightVal = nums[rightIdx];
                int sum = curVal + leftVal + rightVal;
                if (sum > 0) {
                    rightIdx--;
                    continue;
                }
                if (sum < 0) {
                    leftIdx++;
                    continue;
                }
                List<Integer> l = new ArrayList<>();
                l.add(curVal);  
                l.add(leftVal);
                l.add(rightVal);
                ans.add(l);

                // - 两种去重写法
                // leftIdx++;
                // rightIdx--;
                // while(leftIdx < rightIdx && leftVal == nums[leftIdx]) leftIdx++;
                // while(leftIdx < rightIdx && rightVal == nums[rightIdx]) rightIdx--;   

                while(leftIdx < rightIdx && leftVal == nums[leftIdx + 1]) leftIdx++;
                while(leftIdx < rightIdx && rightVal == nums[rightIdx - 1]) rightIdx--;
                leftIdx++;
                rightIdx--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}