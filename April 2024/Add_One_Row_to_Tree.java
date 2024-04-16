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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        addRow(root, val, depth - 1);
        return root;
    }
    public void addRow(TreeNode node, int val, int depth) {
        if (node == null) {
            return;
        }
        if (depth == 1) {
            TreeNode leftNode = new TreeNode(val);
            leftNode.left = node.left;
            node.left = leftNode;

            TreeNode rightNode = new TreeNode(val);
            rightNode.right = node.right;
            node.right = rightNode;
        } else {
            addRow(node.left, val, depth - 1);
            addRow(node.right, val, depth - 1);
        }
    }
}