import java.util.HashMap;
import java.util.Map;

// - https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
class Solution {
    public int findRepeatNumber(int[] nums) {
        Map <Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            if (map.containsKey(val)) {
                return val;
            }
            map.put(val, i);
        }
        return 0;
    }
}