// - https://leetcode-cn.com/problems/string-to-integer-atoi/
class Solution {
    public int myAtoi(String s) {

        // - 排除无用的前导空格
        int len = s.length();

        // - 符号和
        int startIndex = 0;
        char ch = 0;
        int symbol = 1;
        for (int i = 0; i < len; i++) {
            ch = s.charAt(i);
            if(ch != ' '){
                // - 排前边的有空格
                startIndex = i;

                // - 全是空格
                if(i == len - 1) {
                    if(ch >= '0' && ch <= '9'){
                        return ch - '0';
                    }
                    return 0;
                }

                // - 判断符号                ch = s.charAt(i + 1);
                if(ch == '-' || ch == '+' ){
                    //  - +的ascii = 43. ,的ascii是44. -的ascii是45
                    symbol = ',' - ch;
                    startIndex++;
                };
                break;
            }
        }

        // - 开始读取字符串内容
        int result = 0;
        for (int i = startIndex; i < len; i++) {
            ch = s.charAt(i);

            // - 非数字字符, 直接停止遍历
            if(ch > '9' || ch < '0') break;

            // - 读取的是数字 边界判断
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (ch - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && (ch - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // - 不超过边界
            result = result * 10 + (ch - '0') * symbol;
            
        }
        return result;
    }

    public int myAtoi1(String s) {
        int starIdx = 0;
        int len = s.length();
        int sign = 1;
        // - 删除前导空格 并记录符号
        for (;starIdx < len; starIdx++) {
            char ch = s.charAt(starIdx);
            if (ch == ' ') continue;
            if (ch >= '0' && ch <= '9') {
                break;
            }
            if (ch == '-') {
                sign = -1;
                starIdx++;
                break;
            }
            if (ch == '+'){
                starIdx++;
                break;
            }
            return 0;
        }

        int val = 10;
        int ans = 0;
        for (; starIdx < len; starIdx++) {
            char ch = s.charAt(starIdx);
            if (ch < '0' || ch > '9')  return ans;
            int tempVal = (ch - '0');
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && tempVal > Integer.MAX_VALUE % val)) {
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && tempVal > -(Integer.MIN_VALUE % val))) {
                return Integer.MIN_VALUE;
            }

            ans = ans * val + tempVal * sign;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.myAtoi1("-91283472332"));
        System.out.println(s.myAtoi1("+1"));
        System.out.println(s.myAtoi1("01"));

        System.out.println(s.myAtoi("42"));
        System.out.println(s.myAtoi("   -42"));
        System.out.println(s.myAtoi("4193 with words"));
        System.out.println(s.myAtoi("words and 987"));
    }
}