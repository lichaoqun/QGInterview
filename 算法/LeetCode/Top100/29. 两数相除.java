// - https://leetcode-cn.com/problems/divide-two-integers/
class Solution {
    public int divide1(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        
        int dividendSig = (dividend > 0) ? 1 : -1;
        int divisorSig = (divisor > 0) ? 1 : -1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        int result = 0;
        while (dividend - divisor >= 0) {
            dividend -= divisor;
            result++;
        }

        return result * dividendSig * divisorSig;
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        int result = 0;
        boolean negative = (dividend ^ divisor) < 0;
        long dividend_long = Math.abs((long) dividend);
        long divisor_long = Math.abs((long) divisor);

        // - 获取到 2 ^ i * divisor < dividend 中i能到的最大值
        // for (int i = 31; i >= 0;i--) {
        //     int v1 = 1 << i;
        //     int v = divisor_long * v1;
        //     if (dividend_long >= v) {
        //         result += v1;
        //         dividend_long -= v;
        //     }
        // }
        for (int i = 31; i >= 0;i--) {
            long temp = (divisor_long << i);
            if (dividend_long >= temp) {
                result += (1 << i);
                dividend_long -= temp;
            }
        }
        return negative ? -result : result;//符号相异取反
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.divide(-2147483648, -1));
        System.out.println(s.divide(220, 3));
        System.out.println(s.divide(10, 3));

    }
}