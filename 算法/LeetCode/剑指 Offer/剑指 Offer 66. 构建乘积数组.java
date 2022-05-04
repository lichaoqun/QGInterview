// - https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
class Solution {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int ans[] = new int[len];
        if(len == 0) return ans;
        int[] dp1 = new int[len];
        dp1[0] = 1;
        for(int i = 1; i < len; i++){
            dp1[i] = dp1[i - 1] * a[i - 1];
        }

        int[] dp2 = new int[len];
        dp2[len - 1] = 1;
        for(int i = len - 2; i >= 0; i--){
            dp2[i] = dp2[i + 1] *a[i + 1];
        }

        for(int i = 0; i < len; i++){
            ans[i] = dp1[i] * dp2[i];
        }
        return ans;
    }
}