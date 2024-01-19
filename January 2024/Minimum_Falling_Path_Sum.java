class Solution {
    public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    
    int[][] dp = new int[n][n];
   
    for (int i = 0; i < n; i++) {
        dp[0][i] = matrix[0][i];
    }
    
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < n; j++) {
            dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][Math.max(0, j-1)], dp[i-1][Math.min(n-1, j+1)]));
        }
    }
    int minSum = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
        minSum = Math.min(minSum, dp[n-1][i]);
    }
    
    return minSum;
    }
}