// - https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
import java.util.Map;
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(val)) {
                int res = map.get(val);
                if (++res > nums.length / 2) {
                    return val;
                }
                map.put(val, res);
            }else{
                map.put(val, 1);
            }
        }
        return 0;
    }
}