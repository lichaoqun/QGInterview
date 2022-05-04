// - https://leetcode-cn.com/problems/heaters/
import java.util.Arrays;
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // - 排序
        int houseLen = houses.length;
        int heatLen = heaters.length;
        for (int end = houseLen - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 0; begin < end; begin++) {
                int nextIdx = begin + 1;
                int curVal = houses[begin];
                int nextVal = houses[nextIdx];
                if (curVal > nextVal) {
                    houses[begin] = houses[nextIdx];
                    houses[nextIdx] = curVal;
                    sorted = false;
                }
            }
            if (sorted) break;
        }

        for (int end = heatLen - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 0; begin < end; begin++) {
                int nextIdx = begin + 1;
                int curVal = heaters[begin];
                int nextVal = heaters[nextIdx];
                if (curVal > nextVal) {
                    heaters[begin] = nextVal;
                    heaters[nextIdx] = curVal;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
        
        int ans = 0;
        for (int houseIdx = 0, heatIdx = 0; houseIdx < houseLen; houseIdx++) {
            int housePos = houses[houseIdx];
            int curDis = Math.abs(heaters[heatIdx] - housePos);
            for (; heatIdx < heatLen - 1; heatIdx++) {
                int nextDis = Math.abs(heaters[heatIdx + 1] - housePos);
                if (curDis < nextDis) break;
                curDis = nextDis;
            }
            ans = Math.max(ans, curDis);
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.findRadius(new int[]{1,2,3}, new int[]{2});
        s.findRadius(new int[]{1,2,3,4}, new int[]{1,4});
        s.findRadius(new int[]{1,5}, new int[]{2});
        s.findRadius(new int[]{100}, new int[]{5, 6, 7});
    }
}