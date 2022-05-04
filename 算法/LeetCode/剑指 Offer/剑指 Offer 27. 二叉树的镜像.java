import java.util.ArrayList;
import java.util.Queue;

import javax.print.attribute.standard.RequestingUserName;

// - https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/

 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        Queue <TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int size = queue.size();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            // size--;

            if(node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            TreeNode tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;
        }
        return root;
    }
}