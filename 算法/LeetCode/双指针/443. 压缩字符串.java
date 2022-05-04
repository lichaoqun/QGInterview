import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

// - https://leetcode-cn.com/problems/string-compression/
class Solution {
    public int compress1(char[] chars) {
        int slowIdx = 0;
        int fastIdx = 1;
        int len = chars.length;
        String str = new String(chars);
        StringBuffer sb = new StringBuffer();
        while (fastIdx < len) {
            char fastChar = str.charAt(fastIdx);
            char slowChar = str.charAt(slowIdx);
            if (slowChar != fastChar) {
                sb.append(slowChar);
                if (fastIdx - slowIdx > 1) {
                    sb.append(fastIdx - slowIdx);
                }
                slowIdx = fastIdx;
            }
            fastIdx++;
        }
        sb.append(str.charAt(slowIdx));
        if (fastIdx - slowIdx > 1) {
            sb.append(fastIdx - slowIdx);
        }

        str = sb.toString();
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return sb.length();
    }

    public int compress(char[] chars) {
        int slowIdx = 0;
        int fastIdx = 1;
        int len = chars.length;
        int idx = 0;
        while (fastIdx < len) {
            char fastChar = chars[fastIdx];
            char slowChar = chars[slowIdx];
            if (slowChar != fastChar) {
                chars[idx++] = slowChar;
                char[] countArray = intToCharArray(fastIdx - slowIdx);
                for (int i = 0; i < countArray.length; i++) {
                    chars[idx++] = countArray[i];
                }
                slowIdx = fastIdx;
            }
            fastIdx++;
        }
        chars[idx++] = chars[slowIdx];
        char[] countArray = intToCharArray(fastIdx - slowIdx);
        for (int i = 0; i < countArray.length; i++) {
            chars[idx++] = countArray[i];
        }

        return idx;
    }

    public char[] intToCharArray(int count) {
        if (count < 2) return new char[0];
        List<Character> list = new ArrayList<>();
        while (count > 0) {
            list.add(0, (char)((count % 10) + '0'));
            count /= 10;
        }

        int len = list.size();
        char[] result = new char[len];
        for (int i = 0; i < len; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' });
        s.compress(new char[] { 'a', 'b', 'c' });
        s.compress(new char[] { 'a' });
        s.compress(new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' });
    }
}