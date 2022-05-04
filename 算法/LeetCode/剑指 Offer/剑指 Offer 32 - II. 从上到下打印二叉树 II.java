import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// - https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        if (root == null) return l;

        Queue <TreeNode> que = new LinkedList<>();
        que.offer(root);
        int size = que.size();
        int hei = 0;
        List<Integer> subL = new ArrayList<>();
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            size--;
            if ((hei & 0x01) == 0) {
                subL.add(node.val);
            }else{
                subL.add(0, node.val);
            }
            if (node.left != null) {
                que.offer(node.left);
            }
            if (node.right != null) {
                que.offer(node.right);
            }
            if (size == 0) {
                hei++;
                l.add(subL);
                subL = new ArrayList<>();
                size = que.size();
            }
        }
        return l;
    }
}