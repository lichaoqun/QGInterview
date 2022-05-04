import java.util.HashMap;
import java.util.Map;

// - https://leetcode-cn.com/problems/roman-to-integer/
class Solution {
    public int romanToInt(String s) {
        Map <Character, Integer> map = new HashMap <Character, Integer>();
        map.put('V', 5);
        map.put('I', 1);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = map.get(s.charAt(i));
            if (i < n - 1 && value < map.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }

    public int romanToInt1(String s) {
        Map <Character, Integer> map = new HashMap <Character, Integer>();
        map.put('V', 5);
        map.put('I', 1);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int ans = 0;
        int len = s.length();
        for (int idx = 0; idx < len; idx++) {
            int curVal = map.get(s.charAt(idx));
            int nextIdx = idx + 1;
            if (nextIdx < len && curVal < map.get(s.charAt(nextIdx))) {
                ans -= curVal;
                continue;
            }
            ans += curVal;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.romanToInt("III")); 
        System.out.println(s.romanToInt("IV")); 
        System.out.println(s.romanToInt("IX")); 
        System.out.println(s.romanToInt("LVIII")); 
        System.out.println(s.romanToInt("MCMXCIV")); 
    }
}