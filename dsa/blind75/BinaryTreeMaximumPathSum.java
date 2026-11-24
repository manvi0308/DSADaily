package blind75;

import javax.swing.tree.MutableTreeNode;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class BinaryTreeMaximumPathSum {
    private int best = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        dfs(root);
        return best;
    }
    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        best = Math.max(best, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
