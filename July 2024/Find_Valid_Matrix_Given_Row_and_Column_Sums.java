class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int minSum = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = minSum;
                rowSum[i] -= minSum;
                colSum[j] -= minSum;
            }
        }

        return matrix;
    }
}