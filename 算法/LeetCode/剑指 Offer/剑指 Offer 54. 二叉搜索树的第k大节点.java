import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// - https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public int kthLargest(TreeNode root, int k) {
        Stack <TreeNode>stack = new Stack<>();
        List <Integer> list = new ArrayList<>();
        TreeNode curNode = root;
        while (true) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }else{
                if (stack.isEmpty()) break;
                curNode = stack.pop();
                list.add(curNode.val);
                curNode = curNode.right;
            }
        }

        return list.get(list.size() - k);
    }
}