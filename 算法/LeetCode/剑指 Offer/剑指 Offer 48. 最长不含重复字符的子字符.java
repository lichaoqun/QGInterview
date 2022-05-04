import java.util.HashMap;
import java.util.Map;

// - https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
class Solution {
    public int lengthOfLongestSubstring1(String s) {
        int len = s.length();
        int left = 0;
        int max = 0;
        Map <Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                left = Math.max(map.get(ch) + 1, left);
            }
            max = Math.max(max, i - left + 1);
            map.put(ch, i);
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = dp[0];
        Map <Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0) , 0);
        for (int i = 1; i < len; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch) && map.get(ch) + dp[i - 1] >= i){
                dp[i] =  (i - map.get(ch));
            }else{
                dp[i] =  dp[i - 1] + 1;
            }
            map.put(ch, i);
            System.out.println(dp[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}