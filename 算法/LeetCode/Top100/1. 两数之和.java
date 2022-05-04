// - https://leetcode-cn.com/problems/two-sum/
import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // - 使用每个元素作为key, 对应在数组的下标作为value
        Map <Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{i, map.get(key)};
            }
            map.put(nums[i], i);
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] c = s.twoSum(new int[]{1, 2, 4 ,6}, 10);
        for(int i = 0; i<c.length; i++){
            System.out.println(c[i]);
        }
    }
}

