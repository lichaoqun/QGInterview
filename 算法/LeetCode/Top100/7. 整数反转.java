import java.util.Queue;
import java.util.LinkedList;

// - https://leetcode-cn.com/problems/reverse-integer/
class Solution {
    public int reverse(int x) {
        if(x == 0) return 0;

        int result = 0;
        int val = 10;
        while(x != 0){
            if (result < Integer.MIN_VALUE / val || result > Integer.MAX_VALUE / val) {
                return 0;
            }
            int res = x % val;
            x /= val;
            result = result * val + res;
        }
        return (int)result;
    }

    public int reverse2(int x) {
        if(x == 0) return x;
        int ans = 0;
        int val = 10;
        while (x != 0) {
            int tempVal = (x % val);

            // - 边界条件判断
            if (ans > Integer.MAX_VALUE / val || ans == Integer.MAX_VALUE / val && tempVal > Integer.MAX_VALUE % 10) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / val || ans == Integer.MIN_VALUE / val && tempVal < Integer.MIN_VALUE % 10) {
                return 0;
            }
            ans += (ans * val) +  tempVal;
            x /= 10;
        }
        return ans;  
    }

    public int reverse1(int x) {
        if(x == 0) return 0;

        int symbol = (x < 0) ? -1 : 1;
        x = Math.abs(x);
        long result = 0;
        double boundary = Math.pow(2, 31) - 1;
        while(x > 0){
            
            int res = x % 10;
            x = x / 10;

            result = result * 10 + res;

            if (result >= boundary) {
                if (symbol < 0 && result >= boundary + 1) {
                    return 0;
                }else if(symbol > 0 && result >= boundary){
                    return 0;
                }
            }
        }
        return (int)result * symbol;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.reverse(1534236469));
        // System.out.println(s.reverse(10));
        // System.out.println(s.reverse(100));
        // System.out.println(s.reverse(3));
        System.out.println(s.reverse2(-13));
        // System.out.println(s.reverse(133));
        // System.out.println(s.reverse(1333));
        // System.out.println(s.reverse(13333));
    }
}