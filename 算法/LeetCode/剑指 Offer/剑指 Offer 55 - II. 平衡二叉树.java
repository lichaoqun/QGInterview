// - https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        Queue <TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            int leftHei = 0;
            if (node.left != null) {
                que.offer(node.left);
                leftHei = maxDepth(node.left);
            }
            int rightHei = 0;
            if (node.right != null) {
                que.offer(node.right);
                rightHei = maxDepth(node.right);
            }

            if (Math.abs(leftHei - rightHei) > 1) return false;
        }
        return true;
    }

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