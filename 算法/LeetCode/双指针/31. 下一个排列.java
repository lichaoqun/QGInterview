// - https://leetcode-cn.com/problems/next-permutation/
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        // - 逆序查找第一个升序对
        int swapIdx1 = len - 2;
        for (; swapIdx1 >= 0; swapIdx1--) {
            if (nums[swapIdx1] < nums[swapIdx1 + 1]) {
                break;
            }
        }

        // - swapIdx1 = -1, 没有找到升序对, 已经是最大值 反转即可
        int rightIdx = len - 1;
        if (swapIdx1 < 0) {
            for (int idx = 0; idx < (len / 2); idx++) {
                int otherIdx = rightIdx - idx;
                int temp = nums[idx];
                nums[idx] = nums[otherIdx];
                nums[otherIdx] = temp;
            }
            return;
        }

        // // - swapIdx1后找到最小的大于 nums[swapIdx1] 的元素, 这里因为  swapIdx1 后边的元素都是降序的, 所以只要逆序找到第一个nums[swapIdx1] 的元素即可.
        // int swapIdx2 = 0;
        // int minVal = Integer.MAX_VALUE;
        // for (int idx = swapIdx1 + 1; idx < len; idx ++) {
        //     int val = nums[idx] - nums[swapIdx1];
        //     if (val > 0 && val < minVal) {
        //         minVal = val;
        //         swapIdx2 = idx;
        //     }
        // }
        
        // - 逆向找到第一个大于升序对中小的元素的元素
        int swapIdx2 = rightIdx;
        for (; swapIdx2 > swapIdx1; swapIdx2--) {
            if (nums[swapIdx2] > nums[swapIdx1]) {
                break;
            }
        }

        // - 交换找到的元素和小的元素
        int temp = nums[swapIdx1];
        nums[swapIdx1] = nums[swapIdx2];
        nums[swapIdx2] = temp;

        // - 对找到的升序对的小元素的后边开始排序
        swapIdx1++;
        for (int end = rightIdx; end > swapIdx1; end--) {
            boolean sorted = true;
            for (int begin = swapIdx1; begin < end; begin++) {
                int nextIdx = begin + 1;
                int curVal = nums[begin];
                int nextVal = nums[nextIdx];
                if (curVal > nextVal) {
                    nums[begin] = nextVal;
                    nums[nextIdx] = curVal;
                    sorted = false;
                }
            }
            if (sorted)
                break;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.nextPermutation(new int[] { 1, 2, 3 });
        s.nextPermutation(new int[] { 1, 2, 3, 8, 5, 7, 6, 4 });
    }
}