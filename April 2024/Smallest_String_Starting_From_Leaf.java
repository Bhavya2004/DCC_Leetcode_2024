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
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }
    public String dfs(TreeNode node, String suffix) {
        if (node == null) {
            return suffix;
        }
        
        char ch = (char) ('a' + node.val);
        String current = ch + suffix;
        
        if (node.left == null && node.right == null) {
            return current;
        }
        
        String left = dfs(node.left, current);
        String right = dfs(node.right, current);
        
        if (node.left == null) {
            return right;
        }
        
        if (node.right == null) {
            return left;
        }
        
        return left.compareTo(right) <= 0 ? left : right;
    }
}