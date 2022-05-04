import java.util.ArrayList;
import java.util.List;

// - https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
class Solution {
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 2;
        List<int[]> list = new ArrayList<int[]>();
        while (right <= ((target / 2) + 1)) {
            int len = right - left + 1;
            int sum = (right + left) * len / 2;
            if (sum == target) {
                int[] tempList = new int[len];
                for (int i = left; i <= right; i++) {
                    tempList[i - left] = i;
                }
                list.add(tempList);
                left++;
                right = left + 1;
            }else if (sum > target) {
                left++;
            }else{
                right++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}