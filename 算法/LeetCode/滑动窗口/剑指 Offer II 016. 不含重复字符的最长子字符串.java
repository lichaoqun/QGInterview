import java.util.HashMap;
import java.util.Map;

// - https://leetcode-cn.com/problems/wtcaE1/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int left = 0, right = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < len) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right++);
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}