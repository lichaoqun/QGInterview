// - https://leetcode-cn.com/problems/powx-n/
class Solution {
    public double myPow1(double x, int n) {
        int n1 = n;
        if(n < 0){
            n1 = -n;
        }

        while(n1 > 0){
            result *= x;
            n1--;
        }
        if (n < 0) {
            return 1 / result;
        }
        return result;
    }

    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        if(x == -1) return ((n & 1) == 1) ?  -1 : 1;
        if(n == 0) return 1;
        if(n < 0){
            return 1 / quickPow(x, -n);
        }
    return quickPow(x, n);
    }

    public double quickPow(double x, int n){
        if (n < 0) return Integer.MAX_VALUE;
        double result = 1.0;
        double x_long = x;
        while(n > 0){
            if((n & 1) == 1){ // - 奇数
                result *= x_long;
                n--;
            }
            x_long *= x_long;
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(2, -2147483648));
        System.out.println(s.myPow(2.1, 3));
        System.out.println(s.myPow(2.00000, -2));
    }
}