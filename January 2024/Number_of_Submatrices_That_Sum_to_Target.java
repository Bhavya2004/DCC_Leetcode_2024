class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        int count = 0;

        // Calculate the prefix sum matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        // Iterate over all possible submatrices
        for (int top = 1; top <= m; top++) {
            for (int bottom = top; bottom <= m; bottom++) {
                Map<Integer, Integer> submatrixSumCount = new HashMap<>();
                submatrixSumCount.put(0, 1);
                int currentSum = 0;

                for (int col = 1; col <= n; col++) {
                    currentSum = prefixSum[bottom][col] - prefixSum[top - 1][col];
                    count += submatrixSumCount.getOrDefault(currentSum - target, 0);
                    submatrixSumCount.put(currentSum, submatrixSumCount.getOrDefault(currentSum, 0) + 1);
                }
            }
        }

        return count;
    }
}