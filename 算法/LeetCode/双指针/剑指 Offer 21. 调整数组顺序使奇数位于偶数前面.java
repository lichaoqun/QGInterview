// - https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
class Solution {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int idx = 0;
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            // - 奇数
            if ((val & 1) == 1) {
                nums[i] = nums[idx];
                nums[idx++] = val;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.exchange(new int[]{2,1,3,4});
    }
}