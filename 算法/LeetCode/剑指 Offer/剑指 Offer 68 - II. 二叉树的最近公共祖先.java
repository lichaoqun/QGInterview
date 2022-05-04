// - https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List <TreeNode> lp = new ArrayList<>();
        dfs(root, p, lp);
        List <TreeNode> lq = new ArrayList<>();
        dfs(root, q, lq);
        TreeNode ans = null;
        for(int i = 0; i < lp.size() && i < lq.size(); i++){
            if(lp.get(i) == lq.get(i)){
                ans = lp.get(i);
            }
        }
        return ans;
    }

    public void dfs(TreeNode root, TreeNode p, List<TreeNode> list) {
        if(root == null) return;
        list.add(root);
        if (root.val == p.val) return ;
        dfs(root.left, p, list);
        if(list.contains(p)) return;
        dfs(root.right, p, list);
        if(list.contains(p)) return;
        list.remove(root);

    }

}