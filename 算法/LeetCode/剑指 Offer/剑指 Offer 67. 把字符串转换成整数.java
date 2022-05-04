// - https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
class Solution {
    public int strToInt(String str) {
        // - 排除无用的前导空格
        int len = str.length();

        // - 符号和
        int startIndex = 0;
        char ch = 0;
        int symbol = 1;
        for (int i = 0; i < len; i++) {
            ch = str.charAt(i);
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
            ch = str.charAt(i);

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
}