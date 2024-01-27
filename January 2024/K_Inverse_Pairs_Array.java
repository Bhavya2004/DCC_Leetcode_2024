class Solution {
    public int kInversePairs(int n, int k) {
        
        int dp[][] = new int[1001][1001];
        dp[0][0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                for(int z = 0; z <= Math.min(j, i-1); z++) {
                    if(j - z >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i-1][j-z]) % 1000000007;
                    }
                }
            }
        }
        return dp[n][k];

    }
}