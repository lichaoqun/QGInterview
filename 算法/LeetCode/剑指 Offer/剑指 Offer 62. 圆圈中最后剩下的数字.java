// - https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
class Solution {
    public int lastRemaining(int n, int m) {
        return remaining(n, m);
    }
    public int remaining(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = remaining(n - 1, m);
        return ((m) % n + x) % n; // - (m + x) % n
    }
}