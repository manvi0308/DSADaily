package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < count; i++){
                if (queue.peek().left != null)
                    queue.add(queue.peek().left);
                if (queue.peek().right != null)
                    queue.add(queue.peek().right);
                nodes.add(queue.remove().val);
            }
            ans.add(nodes);
        }
        return ans;
    }
}
