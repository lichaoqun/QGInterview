import java.util.HashMap;
import java.util.Stack;

// - https://leetcode-cn.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;

        int len = s.length();
        int max = 0;
        String result = s.substring(0, 1);

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                // - 截取每段字符串
                String s1 =  s.substring(i, j);
                int s1Len = s1.length();
                // - 如果是回文字符串
                if(isPalindrome(s1) && s1Len > max){
                    result = s1;
                    max = s1Len;
                }
            }

            // - 剩余字符串的长度<max 不用在遍历了
            if(max > len - i){
                return result;
            }
        }
        return result;
    }

    public boolean isPalindrome1(String s) {
        int len = s.length();
        if(len == 1) return true;

        Stack <Character> stack = new Stack<Character>();        
        int mid = len >> 1;
        boolean isOddNumLen = ((len & 1) != 0);
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(i < mid){
                stack.push(ch);
            }else{
                if(i == mid && isOddNumLen) continue;
                char tempCh = stack.pop();
                if (tempCh != ch) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isPalindrome(String s) {
        int len = s.length();
        for(int i = 0; i < len / 2; i++){
            if (s.charAt(i) != s.charAt(len - i - 1) ) {
                return false;
            }
        }
        return true;
    }

    public class Solution {
        public String longestPalindrome1(String s) {
                int len = s.length();
                boolean[][]dp = new boolean[len][len];
                int maxSubStrStartIdx = 0;
                int maxSubStrStartLen = 1;
                for (int i = 0; i < len; i++) {
                    dp[i][i] = true;
                }
                for (int subStrLen = 2; subStrLen <= len; subStrLen++) {
                    for (int startIdx = 0; startIdx < len; startIdx++) {
                        int endIdx = startIdx + subStrLen - 1;
                                        
        
                        if(endIdx >= len) break;
                        char startCh = s.charAt(startIdx);
                        char endCh = s.charAt(endIdx);
                        if(startCh == endCh){
                            if(subStrLen == 2){
                                dp[startIdx][endIdx] = true;
                            }else{
                                dp[startIdx][endIdx] = dp[startIdx + 1][endIdx - 1];
                            }
                        }else{
                            dp[startIdx][endIdx] = false;
                        }
                        if (subStrLen > maxSubStrStartLen && dp[startIdx][endIdx] == true) {
                            maxSubStrStartLen = subStrLen;
                            maxSubStrStartIdx = startIdx;
                        }
                    }
                }
                return s.substring(maxSubStrStartIdx, maxSubStrStartIdx + maxSubStrStartLen);
            }
        }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("iopsajhffgvrnyitusobwcxgwlwniqchfnssqttdrnqqcsrigjsxkzcmuoiyxzerakhmexuyeuhjfobrmkoqdljrlojjjysfdslyvckxhuleagmxnzvikfitmkfhevfesnwltekstsueefbrddxrmxokpaxsenwlgytdaexgfwtneurhxvjvpsliepgvspdchmhggybwupiqaqlhjjrildjuewkdxbcpsbjtsevkppvgilrlspejqvzpfeorjmrbdppovvpzxcytscycgwsbnmspihzldjdgilnrlmhaswqaqbecmaocesnpqaotamwofyyfsbmxidowusogmylhlhxftnrmhtnnljjhhcfvywsqimqxqobfsageysonuoagmmviozeouutsiecitrmkypwknorjjiaasxfhsftypspwhvqovmwkjuehujofiabznpipidhfxpoustquzyfurkcgmioxacleqdxgrxbldcuxzgbcazgfismcgmgtjuwchymkzoiqhzaqrtiykdkydgvuaqkllbsactntexcybbjaxlfhyvbxieelstduqzfkoceqzgncvexklahxjnvtyqcjtbfanzgpdmucjlqpiolklmjxnscjcyiybdkgitxnuvtmoypcdldrvalxcxalpwumfx"));
        System.out.println(s.longestPalindrome("aacabdkacaa"));
        System.out.println(s.longestPalindrome("cbbd"));
        System.out.println(s.longestPalindrome("a"));
        System.out.println(s.longestPalindrome("ac"));
        System.out.println(s.longestPalindrome("aa"));
        System.out.println(s.longestPalindrome("aaa"));
        System.out.println(s.longestPalindrome("aaaa"));
        // System.out.println(s.isPalindrome("aaca"));
        // System.out.println(s.isPalindrome("aacc"));
        // System.out.println(s.isPalindrome("acca"));
        // System.out.println(s.isPalindrome("a"));
        // System.out.println(s.isPalindrome("aba"));
        // System.out.println(s.isPalindrome("abba"));
        // System.out.println(s.isPalindrome("abcba"));
        // System.out.println(s.isPalindrome("aa"));
        // System.out.println(s.isPalindrome("aaa"));

    }
}