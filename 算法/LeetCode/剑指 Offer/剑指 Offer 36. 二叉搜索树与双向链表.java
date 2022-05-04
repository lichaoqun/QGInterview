import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.text.html.FormView;

// - https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        // - 中序遍历二叉树
        Stack <Node> stack = new Stack<>();
        Node curNode = root;
        List <Node> l = new ArrayList<>();
        while (true) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }else{
                if(stack.isEmpty()) break;
                curNode = stack.pop();
                l.add(curNode);
                curNode = curNode.right;
            }
        }
        
        int end = l.size() - 1;
        for (int i = 0; i <= end; i++) {
            Node lastNode = (i == 0) ? l.get(end) : l.get(i - 1);
            curNode = l.get(i);
            Node nextNode = (i == end) ? l.get(0) : l.get(i + 1);
            curNode.left = lastNode;
            curNode.right = nextNode;
        }

        return l.get(0);
    }
}