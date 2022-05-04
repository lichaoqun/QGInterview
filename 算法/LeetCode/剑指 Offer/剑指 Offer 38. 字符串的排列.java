import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// - https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
class Solution {
    Set <String> res = new HashSet<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(c, new StringBuilder());
        String[] array = new String[res.size()];
        res.toArray(array);
        return array;
    }
    void dfs(char[] chars, StringBuilder sb){
        if (sb.length() == chars.length) {
            res.add(new String(sb));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c != '0'){
                sb.append(c);
                chars[i] = '0';
                dfs(chars, sb);
                sb.deleteCharAt(sb.length() - 1);
                chars[i] = c;
            }
        } 
    }
}