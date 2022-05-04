// - https://leetcode-cn.com/problems/regular-expression-matching/
class Solution {

    /*
     * 1. 字符串不能以 * 你开头
     * 2. 逐一扫描字符串s的每个字符和p的每个字符
     *  1. p中扫描到. 跳过进行下次循环 sCur++, pCur++;
     *  2. p中扫描到*, 判断*前边的字符是否和当前s扫描到的字符是否相等, 如果相等, p++, s不变
     *  3. 不是这两个字符, 判断s和p是否相等, 相等则s++,p++, 如果不相等, 判断p++是不是*, 如果是*, s++, p++两次; 如果不是, 直接退出
     */
    public boolean isMatch(String s, String p) {
        if(s == p) return true;

        // - 不能以 * 开头
        int pCur = 0;
        if (p.charAt(pCur) == '*')return false;
            
        // - 扫描字符串s
        int sLen = s.length();
        int pLen = p.length();
        int sCur = 0;
        for (sCur = 0; sCur < sLen && pCur <pLen; sCur++) {
            char sCh = s.charAt(sCur);
            char pCh = p.charAt(pCur);
            if(pCh == '.'){
                pCur++;
            }else if(pCh == '*'){// - 扫描到* , 判断*前的字符和p扫描到的字符是否相等
                char lastPCh = p.charAt(pCur - 1);
                if (lastPCh == '.') continue;
                if (sCh != lastPCh) return false;
            }else{
                if(sCh != pCh){// - 字符不相等, 判断后边字符是不是*(如果后边还有字符)
                    if((pLen - 1) == pCur) return false;
                    if(p.charAt(pCur++) != '*') return false;
                }

                // - 字符相等, 直接继续扫描下一个字符
                pCh++;
            }
        }

        if(sCur != sLen) return false;
        if(pCur!= (pLen - 1) && p.charAt(pCur + 1) !='*' && (pCur + 1) != (pLen - 1)) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // System.out.println(s.isMatch("aa", "a"));
        // System.out.println(s.isMatch("aa", "a*"));
        System.out.println(s.isMatch("ab", ".*"));
        // System.out.println(s.isMatch("aab", "c*a*b"));
        // System.out.println(s.isMatch("mississippi", "mis*is*p*."));

    }
}