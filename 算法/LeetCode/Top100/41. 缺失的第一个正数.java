// - https://leetcode-cn.com/problems/first-missing-positive/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int array [] = new int [len];
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            if(val -1 < len && val - 1 >= 0){
                array[val - 1] = 1;
            }
        }

        for (int i = 0; i < len; i++) {
            if (array[i] == 0) {
                return i + 1;
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstMissingPositive(new int[]{2}));
        System.out.println(s.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(s.firstMissingPositive(new int[]{1,2,3}));
        System.out.println(s.firstMissingPositive(new int[]{0,1,2}));
        System.out.println(s.firstMissingPositive(new int[]{3,4,-1, 1}));
        System.out.println(s.firstMissingPositive(new int[]{7, 8, 9 , 11, 12}));
    }
}