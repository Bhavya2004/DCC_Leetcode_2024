import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph using the given edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // Perform a depth-first search (DFS) to find a valid path
        boolean[] visited = new boolean[n];
        return dfs(graph, visited, source, destination);
    }
    
    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int curr, int destination) {
        // If the current vertex is the destination, return true
        if (curr == destination) {
            return true;
        }
        
        // Mark the current vertex as visited
        visited[curr] = true;
        
        // Explore all adjacent vertices
        for (int neighbor : graph.get(curr)) {
            if (!visited[neighbor]) {
                if (dfs(graph, visited, neighbor, destination)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}