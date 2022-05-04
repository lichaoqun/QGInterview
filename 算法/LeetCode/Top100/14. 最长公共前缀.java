// - https://leetcode-cn.com/problems/longest-common-prefix/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        int len = strs.length;
        int idx = 0;
        for (int i = 1; i < len; i++) {
            idx = 0;
            String str = strs[i];
            StringBuilder sb = new StringBuilder();
            while((idx < Math.min(str.length(), res.length()))){   
                if (res.charAt(idx) != str.charAt(idx)) break;
                sb.append(res.charAt(idx));
                idx++;
            }
            res = sb.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[]{"flower","flow","flight"})); 
        System.out.println(s.longestCommonPrefix(new String[]{"dog","racecar","car"})); 
        System.out.println(s.longestCommonPrefix(new String[]{"abc","def"})); 

    }
}