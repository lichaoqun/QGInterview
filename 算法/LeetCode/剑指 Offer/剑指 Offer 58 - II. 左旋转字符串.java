// - https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
class Solution {
    class Solution {
        public String reverseLeftWords(String s, int n) {
            String res = "";
            for(int i = n; i < s.length(); i++)
                res += s.charAt(i);
            for(int i = 0; i < n; i++)
                res += s.charAt(i);
            return res;
        }
    }
}