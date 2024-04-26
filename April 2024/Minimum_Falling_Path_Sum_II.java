class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            // Find the minimum and second minimum values from the previous row
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (dp[i - 1][j] < min1) {
                    min2 = min1;
                    min1 = dp[i - 1][j];
                } else if (dp[i - 1][j] < min2) {
                    min2 = dp[i - 1][j];
                }
            }

            // Calculate the minimum falling path sum for the current row
            for (int j = 0; j < n; j++) {
                if (dp[i - 1][j] == min1) {
                    dp[i][j] = min2 + grid[i][j];
                } else {
                    dp[i][j] = min1 + grid[i][j];
                }
            }
        }

        // Find the minimum falling path sum in the last row
        int minPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minPathSum = Math.min(minPathSum, dp[n - 1][j]);
        }

        return minPathSum;
    }
}