class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        // prefix[i] = sum of stoneValue[0..i-1]
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        
        // dp[i][j] = max score Alice can get playing on subarray [i..j]
        int[][] dp = new int[n][n];
        
        // consider all lengths from 2 up to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                // try every possible split between i..j-1
                for (int k = i; k < j; k++) {
                    long leftSum  = prefix[k + 1] - prefix[i];
                    long rightSum = prefix[j + 1] - prefix[k + 1];
                    if (leftSum < rightSum) {
                        // Bob throws away right part, Alice gains leftSum
                        dp[i][j] = Math.max(dp[i][j],
                                            (int)leftSum + dp[i][k]);
                    } else if (leftSum > rightSum) {
                        // Bob throws away left part, Alice gains rightSum
                        dp[i][j] = Math.max(dp[i][j],
                                            (int)rightSum + dp[k + 1][j]);
                    } else {
                        // equal: Alice chooses which to keep
                        dp[i][j] = Math.max(dp[i][j],
                                            (int)leftSum  + dp[i][k]);
                        dp[i][j] = Math.max(dp[i][j],
                                            (int)rightSum + dp[k + 1][j]);
                    }
                }
            }
        }
        
        return dp[0][n - 1];
    }
}
