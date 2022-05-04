import java.util.Stack;

// - https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
import java.util.Stack;
class MinStack {
    Stack <Integer> s1;
    Stack <Integer>s2;
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || x <= s2.peek()) {
            s2.push(x);
        }
    }
    
    public void pop() {
        if ( s1.pop().equals(s2.peek())) {
            s2.pop();      
        }
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int min() {
        return s2.peek();
    }
}