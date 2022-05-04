// - https://leetcode-cn.com/problems/sorted-merge-lcci/
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int ALen = A.length;
        int AIdx = m - 1;
        int BIdx = n - 1;
        int idx = ALen - 1;
        while (idx >= 0) {
            while (AIdx >= 0 && (BIdx < 0 || A[AIdx] >= B[BIdx])) {
                A[idx--] = A[AIdx--];
            }
            while (BIdx >= 0 && (AIdx < 0 || B[BIdx] >= A[AIdx])) {
                A[idx--] = B[BIdx--];
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.merge(new int[]{1,2,3,0,0,0}, 3, new int []{2,5,6}, 3);
    }
}