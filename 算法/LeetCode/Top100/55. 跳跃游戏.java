// - https://leetcode-cn.com/problems/jump-game/
class Solution {
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > rightMost) return false;
            rightMost = Math.max(rightMost, i + nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{}));
    }
}