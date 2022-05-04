import java.util.Arrays;

// - https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int last = 0;
        for (int i : nums) {
            if(i == 0){
                count++;
                continue;
            }
            if (i == last) return false;
            last = i;
        }
        return nums[4] - nums[count] < 5;
    }
}