// - https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
class Solution {
    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch != ' '){
                sb.append(ch);
                continue;
            }
            sb.append("%20");
        }
        return sb.toString();
    }
}