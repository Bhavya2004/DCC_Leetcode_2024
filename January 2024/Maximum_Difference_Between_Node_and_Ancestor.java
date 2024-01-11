class Solution {
    int maxDifference;
    public int maxAncestorDiff(TreeNode root) {
        maxDifference = 0;
        if (root != null) {
            dfs(root, root.val, root.val);
        }
        return maxDifference;
    }
    public void dfs(TreeNode node, int minAncestor, int maxAncestor) {
        if (node == null) {
            return;
        }

        int currentDifference = Math.max(Math.abs(node.val - minAncestor), Math.abs(node.val - maxAncestor));
        maxDifference = Math.max(maxDifference, currentDifference);

        minAncestor = Math.min(minAncestor, node.val);
        maxAncestor = Math.max(maxAncestor, node.val);

        dfs(node.left, minAncestor, maxAncestor);
        dfs(node.right, minAncestor, maxAncestor);
    }
}