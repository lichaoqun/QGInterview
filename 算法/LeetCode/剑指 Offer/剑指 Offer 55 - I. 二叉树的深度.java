import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

// - https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue <TreeNode> que = new LinkedList<>();
        que.offer(root);
        int hei = 0;
        int size = que.size();
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            size--;
            if (node.left != null) {
                que.offer(node.left);
            }
            if (node.right != null) {
                que.offer(node.right);
            }
            if (size == 0) {
                size = que.size();
                hei++;
            }
        }

        return hei;
    }
}