import java.sql.Array;
import java.util.ArrayList;

// - https://leetcode-cn.com/problems/boats-to-save-people/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // - 排序  使用 Arrays.sort(people)排序不回超时
        int len = people.length;
        for (int end = len - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 0; begin < end; begin++) {
                int nextIdx = begin + 1;
                int curVal = people[begin];
                int nextVal = people[nextIdx];
                if (curVal > nextVal) {
                    people[begin] = nextVal;
                    people[nextIdx] = curVal;
                    sorted = false;
                }
            }
            if(sorted) break;
        }
        
        // - 双指针
        int left = 0, right = len - 1;
        int ans = 0;
        while (left < right) {
           if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            ans++;
        }
        if(left == right) ans++;
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.numRescueBoats(new int[]{3,5,3,4}, 5);
    }
}