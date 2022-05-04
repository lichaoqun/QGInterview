import java.util.HashMap;
import java.util.List;
import java.util.Map;

// - https://leetcode-cn.com/problems/repeated-dna-sequences/solution/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        int k = 10;
        Map <String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<String>();

        for (int left = 0; left <= len - k; left++) {
            int right = left + k;
            String subStr = s.substring(left, right);
            map.put(subStr, map.getOrDefault(subStr, 0) + 1);
            if (map.get(subStr) == 2) {
                ans.add(subStr);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestDupSubstring("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}