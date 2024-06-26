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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedValues = new ArrayList<>();
        inorderTraversal(root, sortedValues);
        return buildBalancedBST(sortedValues, 0, sortedValues.size() - 1);
    }
    public void inorderTraversal(TreeNode node, List<Integer> sortedValues) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, sortedValues);
        sortedValues.add(node.val);
        inorderTraversal(node.right, sortedValues);
    }

    public TreeNode buildBalancedBST(List<Integer> sortedValues, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(sortedValues.get(mid));
        root.left = buildBalancedBST(sortedValues, start, mid - 1);
        root.right = buildBalancedBST(sortedValues, mid + 1, end);
        return root;
    }
}