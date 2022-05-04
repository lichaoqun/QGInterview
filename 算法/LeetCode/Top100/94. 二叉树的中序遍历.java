import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// - https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        Stack <TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root;
        while (true) {

            // - 先一直向左走, 将左子树加到栈中
            if (node != null) {
                s.push(node);
                node = node.left;
                continue;
            }

            // - 元素都pop出去了
            if (s.empty()) break;

            // - 到了最左子树
            node = s.pop();
            l.add(node.val);
            node = node.right;
        }
        return l;
    }

    public static void main(String[] args) {
        
        
    }
}
