import java.util.Stack;

// - https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack <Integer> s = new Stack<>();
        int idx = 0;
        for (int i = 0; i < pushed.length; i++) {
            s.push(pushed[i]);
            while (!s.isEmpty() && s.peek() == popped[idx]) {
                s.pop();
                idx++;
            }
        }
        return s.isEmpty();
    }
}