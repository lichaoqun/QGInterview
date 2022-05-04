import java.util.Set;
import java.util.TreeSet;

import javax.print.attribute.standard.RequestingUserName;

// - https://leetcode-cn.com/problems/contains-duplicate-iii/
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> ts = new TreeSet<>();
        int len = nums.length;
        for (int idx = 0; idx < len; idx++) {
            Long val = nums[idx] * 1L;
            Long lessMaxVal = ts.floor(val);
            Long greatMinVal = ts.ceiling(val);
            if (lessMaxVal != null && val - lessMaxVal <= t) return true;
            if (greatMinVal != null && greatMinVal - val <= t) return true;

            ts.add(val);
            if (idx >= k) {
                ts.remove(nums[idx - k ] * 1L);
            }
        }
        return false;
    }
}