import java.util.HashMap;
import java.util.Map;

// - https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int  left = 0;
        int ans = 0;
        Map <Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, i);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}