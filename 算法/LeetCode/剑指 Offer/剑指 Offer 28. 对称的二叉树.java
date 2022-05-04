import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.management.Query;

import apple.laf.JRSUIUtils.Tree;

// - https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/

 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue <TreeNode> que = new LinkedList<TreeNode>();
        List <TreeNode> list = new ArrayList<>();
        que.offer(root);
        int size = que.size();
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            size--;
            if (node.left != null) {
                que.offer(node.left);
            }
            list.add(node.left);
            if (node.right != null) {
                que.offer(node.right);
            }
            list.add(node.right);
            if (size == 0) {
                int left = 0;
                int right = list.size() - 1;
                while (left < right) {
                    if(list.get(left) != null && list.get(right) == null ) return false;
                    if(list.get(left) == null && list.get(right) != null ) return false;
                    if(list.get(left) != null && list.get(right) != null && list.get(left).val != list.get(right).val) return false;
                    left++;
                    right--;
                }
                list.clear();
                size = que.size();
            }
        }
        return true;
    }
}