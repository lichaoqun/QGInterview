// - https://leetcode-cn.com/problems/count-and-say/
class Solution {
    public String countAndSay1(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;

            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }
        
        return str;
    }

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            int curPos = 0;
            int startPos = 0;
            StringBuilder sb = new StringBuilder();
            int len = result.length();
            while (curPos < len) {
                char ch = result.charAt(startPos);
                while(curPos < len && result.charAt(curPos) == ch){
                    curPos++;
                }
                sb.append(curPos - startPos).append(ch);
                startPos = curPos;
            }
            result = sb.toString();
        }
        return result; 
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(4));
    }
}