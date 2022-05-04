// - https://leetcode-cn.com/problems/sqrtx/

class Solution {
    public int mySqrt1(int x) {
        if (x < 2) return x;
        for (long i = 0; i <= x; i++) {
            if (i * i > (long)x){
                return (int)(i - 1);
            }
        }
        return 0;
    }

    public int mySqrt2(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = (left + right - 1) / 2;
            if((long)mid * mid <= x){
                left = mid + 1;
                ans = mid;
                continue;
            }
            right = mid - 1;
        }
        return ans;
    }

    public int mySqrt(int x) {
        if (x < 2) return x;
        int begin = 0, end = x, ans = 0;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if((long)mid * mid <= x){
                begin = mid + 1;
                ans = mid;
                continue;
            }
            end = mid;
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(0));
        System.out.println(s.mySqrt(1));
        System.out.println(s.mySqrt(2));
        System.out.println(s.mySqrt(2147395600));
    }
}