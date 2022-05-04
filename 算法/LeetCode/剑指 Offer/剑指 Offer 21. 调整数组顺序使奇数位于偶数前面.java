// - https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
class Solution {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            // - 奇数
            while (left < right && ((nums[left] & 0x1) == 0x1)) left++;
            while (left < right && ((nums[right] & 0x1) == 0x0)) right--;
            int oriLeft = nums[left];
            nums[left] = nums[right];
            nums[right] = oriLeft;
        }
        return nums;
    }
}