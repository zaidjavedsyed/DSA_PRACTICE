class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int numRollsToTarget(int d, int f, int target) {
        // dp[i][j]: number of ways to get sum j with i dice
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= d; i++) {
            for (int sum = 1; sum <= target; sum++) {
                long ways = 0;
                // try each face value
                for (int face = 1; face <= f && face <= sum; face++) {
                    ways += dp[i - 1][sum - face];
                }
                dp[i][sum] = (int)(ways % MOD);
            }
        }
        
        return dp[d][target];
    }
}
