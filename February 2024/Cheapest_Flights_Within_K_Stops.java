class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[k + 2][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][src] = 0;

        for (int i = 1; i <= k + 1; i++) {
            dp[i][src] = 0;
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                if (dp[i - 1][from] != Integer.MAX_VALUE) {
                    dp[i][to] = Math.min(dp[i][to], dp[i - 1][from] + price);
                }
            }
        }

        return dp[k + 1][dst] == Integer.MAX_VALUE ? -1 : dp[k + 1][dst];
    }
}