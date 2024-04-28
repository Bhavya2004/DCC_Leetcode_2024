public class Solution {

    private List<List<Integer>> tree;
    private int[] subtreeSizes;
    private int[] distanceSums;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // Initialize tree as adjacency list, subtree sizes and distance sums.
        tree = new ArrayList<>();
        subtreeSizes = new int[n];
        distanceSums = new int[n];
        
        // Prepare the tree adjacency list
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        // First DFS to calculate subtree sizes and initial distance sums at root (0)
        dfs1(0, -1);

        // Second DFS to adjust distances based on the parent's computed values
        dfs2(0, -1);

        // Return the computed distance sums
        return distanceSums;
    }

    private void dfs1(int node, int parent) {
        subtreeSizes[node] = 1; // Start with counting itself
        for (int neighbor : tree.get(node)) {
            if (neighbor == parent) continue; // Avoid going back to parent
            dfs1(neighbor, node);
            subtreeSizes[node] += subtreeSizes[neighbor];
            distanceSums[0] += distanceSums[neighbor] + subtreeSizes[neighbor];
        }
    }

    private void dfs2(int node, int parent) {
        // Root's distance sum is already computed in dfs1
        for (int neighbor : tree.get(node)) {
            if (neighbor == parent) continue;
            // Compute the distance sum for the neighbor based on the node's distance sum
            distanceSums[neighbor] = distanceSums[node] - subtreeSizes[neighbor] + (subtreeSizes.length - subtreeSizes[neighbor]);
            dfs2(neighbor, node);
        }
    }
}