import java.util.HashMap;
import java.util.Map;

// - https://leetcode-cn.com/problems/fruit-into-baskets/
class Solution {
    public int totalFruit(int[] fruits) {
        int  len = fruits.length;
        Map <Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;
        while (right < len) {
            int curVal = fruits[right++];
            if (map.size() <= 2) {
                map.put(curVal, map.getOrDefault(curVal, 0) + 1);
                while (map.size() > 2) {
                    int firstVal = fruits[left++];
                    int firstValCount = map.get(firstVal);
                    if (--firstValCount == 0) {
                        map.remove(firstVal);
                        continue;
                    }
                    map.put(firstVal, firstValCount);
                }
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // s.totalFruit(new int[]{1,2,1});
        s.totalFruit(new int[]{0,1,2,2});
        s.totalFruit(new int[]{1,2,3,2,2});
    }
}