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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        deleteNodes(root, toDeleteSet, forest, true);
        return forest;
    }
    private TreeNode deleteNodes(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest, boolean isRoot) {
        if (node == null) {
            return null;
        }

        boolean deleted = toDeleteSet.contains(node.val);
        if (isRoot && !deleted) {
            forest.add(node);
        }

        node.left = deleteNodes(node.left, toDeleteSet, forest, deleted);
        node.right = deleteNodes(node.right, toDeleteSet, forest, deleted);

        return deleted ? null : node;
    }
}