import java.util.List;
import java.util.ArrayList;

// - https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode-solution/
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastChars = new int[26];
        int length = s.length();

        // - 记录字母最后出现的下表
        for (int idx = 0; idx < length; idx++) {
            char ch = s.charAt(idx);
            lastChars[(int)(ch - 'a')] = idx;
        }

        // - 遍历字符串
        int end = 0;
        int begin = 0;
        List<Integer> ans = new ArrayList<Integer>();
        for (int idx = 0; idx < length; idx++) {
            char ch = s.charAt(idx);
            end = Math.max(end, lastChars[(int)(ch - 'a')]);
            if (idx == end) {
                ans.add(end - begin + 1);
                begin = (idx + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.partitionLabels("ababcbacadefegdehijhklij"));
    }
}