package trees;

public class DiameterOfBinaryTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int diameter = 0;
    public int height(TreeNode root){
        // helper function to return height of binary tree
        if (root == null)
            return 0;
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        int localDiameter = lHeight + rHeight;
        diameter = Math.max(diameter, localDiameter);
        return Math.max(lHeight, rHeight) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }
}
