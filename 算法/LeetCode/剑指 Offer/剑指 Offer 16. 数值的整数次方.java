// - https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        while(n > 0){
            res *= x;
            n--;
        }    
        return res;
    }
}