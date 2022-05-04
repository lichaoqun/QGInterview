// - https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) return 0;
        
        // - 长度一定大于2
        ArrayList arr = new ArrayList();
        int max = 1;
        for(int i = 0; i < len; i++){
            arr.add(s.charAt(i));
            for(int j = i + 1; j < len; j++){
            char current = s.charAt(j);

                // - 出现重复字符
                if(arr.contains(current)){
                    max = Math.max(max, arr.size());
                    arr.clear();
                    break;
                }   

                // - 未出现重复字符
                arr.add(current);

                // - 遍历到了结尾的位置没有出现的重复的
                if(j == len - 1){
                    max = Math.max(max, arr.size());
                    arr.clear();
                }
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        if (len < 2) return len;

        // - leftIdx 是窗口的左边界, 应该是不断递增的.
        int leftIdx = 0;
        int ans = 0;
        Map <Character, Integer> map = new HashMap<Character, Integer>();
        for (int idx = 0; idx < s.length(); idx++) {
            char ch = s.charAt(idx);

            // - 出现过这字符, 窗口滑动
            if (map.containsKey(ch)) {

                // - 更新窗口左边界, Math.max防止abba的情况, leftIndex 回溯.
                leftIdx = Math.max(leftIdx, map.get(ch) + 1);
            }

            // - 记录当前字符最后一次出现的下标
            map.put(ch, idx);

            // - 记录窗口大小
            ans = Math.max(ans, idx - leftIdx + 1);
        }        
        return ans; 
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int c = s.lengthOfLongestSubstring1("abcad");
        System.out.println(c);
    }
}