class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] degree = new int[n + 1];
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            degree[u]++;
            degree[v]++;
            
            if (degree[u] == n - 1) {
                return u;
            }
            
            if (degree[v] == n - 1) {
                return v;
            }
        }
        
        return -1; // No center found
    }
}