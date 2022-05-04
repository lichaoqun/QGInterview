import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import apple.laf.JRSUIConstants.BooleanValue;

// - https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
class Solution {
    public String reverseVowels1(String s) {
        int len = s.length();
        List<Integer>idxList = new ArrayList<>();
        List<Character>vowelsList = new ArrayList<>();
        vowelsList.add('a');
        vowelsList.add('e');
        vowelsList.add('i');
        vowelsList.add('o');
        vowelsList.add('u');
        vowelsList.add('A');
        vowelsList.add('E');
        vowelsList.add('I');
        vowelsList.add('O');
        vowelsList.add('U');

        for (int idx = 0; idx < len; idx++) {
            char ch = s.charAt(idx);
            if (vowelsList.contains(ch)) {
                idxList.add(idx);
            }
        }

        int leftIdx = 0;
        int rightIdx = idxList.size() - 1;
        char[] chars = s.toCharArray();
        while (leftIdx < rightIdx) {
            char temp = chars[idxList.get(leftIdx)];
            chars[idxList.get(leftIdx++)] = chars[idxList.get(rightIdx)];
            chars[idxList.get(rightIdx--)] = temp;
        }
        return new String(chars);
    }

    public String reverseVowels(String s) {
        int len = s.length();
        char[]chars = s.toCharArray();
        Map <Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);

        int x = Math.abs((int)('a' - 'A'));
        int leftIdx = 0, rightIdx = len - 1;

        while (leftIdx < rightIdx) {
            char leftCh = chars[leftIdx];
            char otherLeftCh  = (char)(leftCh + x);
            if (map.get(leftCh) != null || map.get(otherLeftCh) != null) {
                while (rightIdx > leftIdx) {
                    char rightCh = chars[rightIdx];
                    char otherRightCh = (char)(rightCh + x);
                    if (map.get(rightCh) == null && map.get(otherRightCh) == null) {
                        rightIdx--;
                        continue;
                    }
                    break;
                }
                char temp = chars[leftIdx];
                chars[leftIdx++] = chars[rightIdx];
                chars[rightIdx--] = temp;
                continue;
            }

            char rightCh = chars[rightIdx];
            char otheRightCh  = (char)(rightCh + x);
            if (map.get(rightCh) != null || map.get(otheRightCh) != null) {
                while (rightIdx > leftIdx) {
                    leftCh = chars[leftIdx];
                    otherLeftCh = (char)(leftCh + x);
                    if (map.get(leftCh) == null && map.get(otherLeftCh) == null) {
                        leftIdx++;
                        continue;
                    }
                    break;
                }
                char temp = chars[leftIdx];
                chars[leftIdx++] = chars[rightIdx];
                chars[rightIdx--] = temp;
                continue;
            }

            leftIdx++;
            rightIdx--;
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.reverseVowels("hello");
        s.reverseVowels("leetcode");
    }
}