class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Create a memoization table to store the maximum cherries collected
        int[][][] memo = new int[rows][cols][cols];

        // Initialize the memoization table with -1 to indicate unvisited cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        // Call the recursive function to calculate the maximum cherries
        return dfs(grid, memo, 0, 0, cols - 1);
    }
    public int dfs(int[][] grid, int[][][] memo, int row, int col1, int col2) {
            // Check if the current position is out of bounds or already visited
            if (row == grid.length || col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
                return 0;
            }

            // Check if the result is already memoized
            if (memo[row][col1][col2] != -1) {
                return memo[row][col1][col2];
            }

            // Calculate the cherries collected at the current position
            int cherries = grid[row][col1] + (col1 != col2 ? grid[row][col2] : 0);

            // Calculate the maximum cherries collected by moving to the next row
            int maxCherries = 0;
            for (int nextCol1 = col1 - 1; nextCol1 <= col1 + 1; nextCol1++) {
                for (int nextCol2 = col2 - 1; nextCol2 <= col2 + 1; nextCol2++) {
                    maxCherries = Math.max(maxCherries, dfs(grid, memo, row + 1, nextCol1, nextCol2));
                }
            }

            // Update the memoization table
            memo[row][col1][col2] = cherries + maxCherries;

            return memo[row][col1][col2];
        }
}