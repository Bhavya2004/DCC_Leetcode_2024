public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    int currentGold = dfs(grid, i, j);
                    maxGold = Math.max(maxGold, currentGold);
                }
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        int originalGold = grid[row][col];
        grid[row][col] = 0; 

        int maxGold = 0;
        maxGold = Math.max(maxGold, dfs(grid, row - 1, col)); // Up
        maxGold = Math.max(maxGold, dfs(grid, row + 1, col)); // Down
        maxGold = Math.max(maxGold, dfs(grid, row, col - 1)); // Left
        maxGold = Math.max(maxGold, dfs(grid, row, col + 1)); // Right

        grid[row][col] = originalGold;
        return maxGold + originalGold;
    }
}