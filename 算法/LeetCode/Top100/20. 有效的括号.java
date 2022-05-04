import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// - https://leetcode-cn.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        Map <Character, Character> map = new HashMap<Character, Character>();
        Stack <Character> stack = new Stack <Character> ();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        int len = s.length();
        for (int idx = 0; idx < len; idx++) {
            char ch = s.charAt(idx);

            // - 读取到的字符是左括号
            if (map.containsKey(ch)) {
                stack.push(ch);
                continue;
            }

            // - 读取到的字符是右括号, 且目前是个空栈, 返回错误
            if (stack.isEmpty()) return false;

            // - 栈顶的左括号不可以和当前的右括号对应, 返回错误
            char topCh = stack.peek();
            if (ch != map.get(topCh)) return false;

            // - 栈顶的左括号可以和当前的右括号对应
            stack.pop();
        }

        // - 字符遍历完成, 如果栈中还有元素, 直接返回错误
        if (!stack.isEmpty()) return false;

        // - 判断完成, 返回正确
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
        System.out.println(s.isValid("([)]"));
    }

}