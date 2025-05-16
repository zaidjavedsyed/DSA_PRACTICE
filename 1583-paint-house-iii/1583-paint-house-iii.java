import java.util.Arrays;

class Solution {
    private static final int INF = 1_000_000_000;
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // dp[i][j][k]:
        // min cost to paint first i houses (1…i),
        // with house i painted color j (1…n),
        // and having formed exactly k neighborhoods so far.
        int[][][] dp = new int[m + 1][n + 1][target + 1];
        for (int i = 0; i <= m; i++) 
            for (int j = 0; j <= n; j++) 
                Arrays.fill(dp[i][j], INF);
        
        // Base: no houses painted, no neighborhoods, “last color” = 0
        dp[0][0][0] = 0;
        
        for (int i = 1; i <= m; i++) {
            int fixedColor = houses[i - 1];  // 0 if unpainted, else 1..n
            for (int color = 1; color <= n; color++) {
                if (fixedColor != 0 && fixedColor != color) {
                    // can't paint with this color
                    continue;
                }
                int paintCost = (fixedColor == 0 ? cost[i - 1][color - 1] : 0);
                
                for (int k = 1; k <= target; k++) {
                    // try all possible previous colors (0..n)
                    for (int prev = 0; prev <= n; prev++) {
                        int prevK = k - (prev == color ? 0 : 1);
                        if (prevK < 0) continue;
                        int prevCost = dp[i - 1][prev][prevK];
                        if (prevCost == INF) continue;
                        dp[i][color][k] = Math.min(
                            dp[i][color][k],
                            prevCost + paintCost
                        );
                    }
                }
            }
        }
        
        // answer: painting all m houses, exactly target neighborhoods,
        // minimize over final color = 1..n
        int ans = INF;
        for (int color = 1; color <= n; color++) {
            ans = Math.min(ans, dp[m][color][target]);
        }
        return ans == INF ? -1 : ans;
    }
}
