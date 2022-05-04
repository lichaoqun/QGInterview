// - https://leetcode-cn.com/problems/contains-duplicate-ii/
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> hs = new HashSet<Integer>();
        int len = nums.length;
        for (int idx = 0; idx < len; idx++) {
            if (idx > k) {
                hs.remove(nums[idx - k - 1]);
            }
            if (!hs.add(nums[idx])) {
                return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;
        for (int idx = 0; idx < len; idx++) {
            int val = nums[idx];
            if (map.containsKey(val) && (idx - map.get(nums[idx])) <= k) {
                return true;
            }
            map.put(n, val);
        }
        return false;
    }
}