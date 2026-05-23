package trees;

public class DiameterOfBinaryTree extends TreeNode {
    int diameter = 0;

    public DiameterOfBinaryTree(int val) {
        super(val);
    }

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
