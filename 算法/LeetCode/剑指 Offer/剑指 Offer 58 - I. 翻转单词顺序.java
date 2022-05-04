import java.util.ArrayList;
import java.util.List;

// - https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
class Solution {
    public String reverseWords(String s) {
        int slow = 0;
        int fast = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        List <String> list = new ArrayList<>();
        int endIdx = len - 1;
       while (fast < len) {
           if (s.charAt(fast) == ' ') {
               if (slow == fast) {
                    slow = fast + 1;
               }else{
                    list.add(s.substring(slow, fast));
                    slow = fast + 1;
               }
           }else if(fast == endIdx){
            list.add(s.substring(slow, len));
           }
           fast++;
       }

       for (int i = list.size() - 1; i >= 0; i--) {
           sb.append(list.get(i));
           if (i != 0) {
               sb.append(" ");
           }
       }
       return sb.toString();
    }
}
