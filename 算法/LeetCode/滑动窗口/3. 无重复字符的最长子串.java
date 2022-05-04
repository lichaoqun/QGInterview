import java.util.HashMap;
import java.util.Map;

// - https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Map <Character, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                left = Math.max(map.get(ch) + 1, left);
            }
            map.put(ch, i);
            ans = Math.max(i - left + 1, max);
        }
        return ans;
    }
}