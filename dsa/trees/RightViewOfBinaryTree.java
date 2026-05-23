package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {
    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
/*
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
        return ans;*/
public List<Integer> rightView(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        return ans;
    }
}
