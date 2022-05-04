// - https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
class Solution {
    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n);
        int[] res = new int[end - 1];
        for(int i = 1; i < end; i++)
            res[i-1] = i;
        return res;
    }
}