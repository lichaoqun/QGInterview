import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

// - https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
class Solution {
    public int[][] findContinuousSequence(int target) {
        int leftIdx= 1;
        int rightIdx = 2;
        int halfTarget = target >> 1;
        int sum = leftIdx + rightIdx;
        List<int[]> ans = new ArrayList<>();
        while (leftIdx <= halfTarget) {
            if(sum < target){
                sum += (++rightIdx);
                continue;
            }
            if (sum > target) {
                sum -= (leftIdx++);
                continue;
            }

            int count = rightIdx - leftIdx + 1;
            int[]tempArray = new int[count];
            for (int i = 0; i < count; i++) {
                tempArray[i] = leftIdx + i;
            }
            ans.add(tempArray);

            // - 窗口移动
            sum -= (leftIdx++);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        System.out.println((new Solution().findContinuousSequence(4)));
    }
}