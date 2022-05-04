import java.util.ArrayList;
import java.util.List;

// - https://leetcode-cn.com/problems/3sum/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (len < 3) return ans;

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
            if (sorted) break;
        }

        // - 遍历
        for (int idx = 0; idx < nums.length; idx++) {
            int curVal = nums[idx];
            if (curVal > 0) return ans;
            // - 过滤掉idx递增时候, val相同的数组元素
            if (idx > 0 && curVal == nums[idx - 1]) continue;
            int left = idx + 1;
            int right = len - 1;

            // - idx固定, 时候寻找leftVal + rightVal + curVal == 0的数组元素
            while(left < right){
                int leftVal = nums[left];
                int rightVal = nums[right];
                int sum = curVal + leftVal + rightVal;

                // - sum > 0, right--
                if (sum > 0) {
                    right--;
                    continue;
                }

                // - sum < 0, left++
                if (sum < 0) {
                    left++;
                    continue;
                }

                // - sum == 0, 加入数组
                ArrayList list = new ArrayList<>();
                list.add(curVal);
                list.add(leftVal);
                list.add(rightVal);
                ans.add(list);

                // - left和right移动, 过滤掉值相同的元素
                while (left < right && leftVal == nums[left + 1]) left++;
                while (left < right && rightVal == nums[right - 1]) right--;
                left++;
                right--;
            }

        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len < 3) return ans;

        // - 排序
        for (int end = len - 1; end > 0; end--) {
            for (int begin = 0; begin < end; begin++) {
                int nextIdx = begin + 1;
                int curVal = nums[begin];
                int nextVal = nums[nextIdx];
                if (curVal > nextVal) {
                    nums[begin] = nextVal;
                    nums[nextIdx] = curVal;
                }
            }
        }

        // - 遍历
        for (int idx = 0; idx < len; idx++) {
            int curVal = nums[idx];
            if (curVal > 0) return ans;
            if (idx > 0 && curVal == nums[idx - 1]) continue;
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
                while (leftIdx < rightIdx && leftVal == nums[leftIdx + 1]) leftIdx++;
                while (leftIdx < rightIdx && rightVal == nums[rightIdx - 1]) rightIdx--;
                leftIdx++;
                rightIdx--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.threeSum(new int[]{-1,0,1,2,-1,-4}));

        // s.threeSum(new int[]{});
        // System.out.println(s.threeSum1(new int[] { 0, 0, 0, 0, 0, 0 }));
    }
}
