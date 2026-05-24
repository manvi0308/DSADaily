package trees;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBinaryTree {
    /*
            1
         2      3
            5      4

        O/P -> 1, 3, 4
     */
    public List<Integer> rightView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        rightDFS(root, 0, res);
        return res;
    }
    public void rightDFS(TreeNode node, int level, List<Integer> list){
        if (node == null)
            return;
        if (list.size() == level)
            list.add(node.val);
        rightDFS(node.right, level + 1, list);
        rightDFS(node.left, level + 1, list);
    }
}
