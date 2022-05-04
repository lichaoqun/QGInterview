import java.util.ArrayList;
import java.util.List;

// - https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = getPath(root, p);
        List<TreeNode> l2 = getPath(root, q);
        for (TreeNode treeNode : l1) {
            System.out.println(treeNode.val);   
        }
        System.out.println("---");
        for (TreeNode treeNode : l2) {
            System.out.println(treeNode.val);   
        }

        TreeNode ans = null;
        for (int i = 0; i < l1.size() && i < l2.size(); i++) {
            if (l1.get(i) == l2.get(i)) {
                ans = l1.get(i);
            }
        }
        return ans;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List <TreeNode> path = new ArrayList<>();
        while (root != null) {
            path.add(root);
            int curval = root.val;
            int targetVal = target.val;
            if (targetVal == curval) return path;
            if (targetVal > curval) {
                root = root.right;
                continue;
            }
            root = root.left;
        }
        return path;
    }
}