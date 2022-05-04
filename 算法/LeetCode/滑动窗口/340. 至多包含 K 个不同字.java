import java.util.HashMap;
import java.util.Map;

// -
// https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters/
/**
 * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 则 T 为 "ece"，所以长度为 3。
 * 
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 则 T 为 "aa"，所以长度为 2。
 **/

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map <Character, Integer>map = new HashMap<>();
        int left = 0;
        int right = 0;
        int len = s.length();
        int ans = 0;
        while (right < len) {
            char rightCh = s.charAt(right++);
            if (map.size() <= k) {
                map.put(rightCh, map.getOrDefault(rightCh, 0) + 1);
                while (map.size() > k) {
                    char leftCh = s.charAt(left++);
                    int count = map.get(leftCh);
                    if (--count == 0) {
                        map.remove(leftCh);
                        continue;
                    }
                    map.put(leftCh, count);
                    
                }
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}