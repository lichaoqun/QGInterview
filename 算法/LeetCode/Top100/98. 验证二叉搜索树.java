// - https://leetcode-cn.com/problems/validate-binary-search-tree/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public boolean isValidBST(TreeNode root) {
        Stack <TreeNode> s = new Stack<TreeNode>();
        double lastVal = -Double.MAX_VALUE;
        while (true) {
            if (root != null) {
                s.push(root);
                root = root.left;
                continue;
            }
            if (s.isEmpty()) return true;

            root = s.pop();
            if (lastVal >= root.val) return false;
            lastVal = root.val;
            root = root.right;
        }
    }

    public static void main(String[] args) {
        
        
    }
}
