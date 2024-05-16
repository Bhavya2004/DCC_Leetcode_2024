/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == 1;
        }

        boolean leftResult = evaluateTree(root.left);
        boolean rightResult = evaluateTree(root.right);

        if (root.val == 2) {
            return leftResult || rightResult;
        } else if (root.val == 3) {
            return leftResult && rightResult;
        }

        return false;
    }
}