public class Solution {
    /**
     * Returns the maximum difference (Alice's score minus Bob's score)
     * under optimal play for Stone Game VII.
     */
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        // prefix[i] = sum of stones[0..i-1]
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        // dp[i][j]: max score difference current player can achieve
        // from subarray stones[i..j]
        int[][] dp = new int[n][n];

        // fill for lengths from 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                // total sum of stones[i..j]
                int total = prefix[j + 1] - prefix[i];
                // If remove left stone at i:
                //   score gained = total - stones[i]
                //   opponent then can achieve dp[i+1][j],
                //   so net gain = (total - stones[i]) - dp[i+1][j]
                int removeLeft = (total - stones[i]) - dp[i + 1][j];
                // If remove right stone at j:
                //   score gained = total - stones[j]
                //   opponent then can achieve dp[i][j-1],
                //   so net gain = (total - stones[j]) - dp[i][j-1]
                int removeRight = (total - stones[j]) - dp[i][j - 1];
                dp[i][j] = Math.max(removeLeft, removeRight);
            }
        }

        // Alice starts on the whole range [0..n-1]
        return dp[0][n - 1];
    }
}
