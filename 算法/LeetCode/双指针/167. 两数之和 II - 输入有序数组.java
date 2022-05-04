// - https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int leftIdx = 0;
        int rightIdx = len - 1;
        int[] ans = new int[2];
        while (leftIdx < rightIdx) {
            int sum = numbers[leftIdx] + numbers[rightIdx];
            if (sum > target) {
                rightIdx--;
                continue;
            }
            if (sum < target) {
                leftIdx++;
                continue;
            }
            ans[0] = leftIdx + 1;
            ans[1] = rightIdx + 1;
            return ans;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        s.twoSum(new int []{3,24,50,79,88,150,345}, 200);
    }
}