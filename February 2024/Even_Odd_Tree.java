import java.util.LinkedList;
import java.util.Queue;
public class Even_Odd_Tree {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int prevValue = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if (level % 2 == 0) {
                    if (node.val % 2 == 0 || node.val <= prevValue) {
                        return false;
                    }
                } else {
                    if (node.val % 2 != 0 || node.val >= prevValue) {
                        return false;
                    }
                }
                
                prevValue = node.val;
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            level++;
        }
        
        return true;
    }
}
