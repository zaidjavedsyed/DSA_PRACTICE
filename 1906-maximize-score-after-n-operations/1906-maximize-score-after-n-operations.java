import java.util.Arrays;

public class Solution {
    /**
     * Returns the maximum score after n operations pairing up 2n numbers.
     * Uses bitmask DP: dp[mask] = max score achievable using the subset 'mask' of elements.
     */
    public int maxScore(int[] nums) {
        int m = nums.length;
        int maxMask = 1 << m;
        int[] dp = new int[maxMask];
        
        // Precompute all pairwise gcds
        int[][] gcd = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                gcd[i][j] = gcd(nums[i], nums[j]);
            }
        }
        
        // Iterate over all masks
        for (int mask = 0; mask < maxMask; mask++) {
            int used = Integer.bitCount(mask);
            // only proceed if used is even (we've done used/2 operations so far)
            if ((used & 1) != 0) continue;
            int op = used / 2 + 1;  // next operation index (1-based)
            
            // try pairing any two unused elements i < j
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) continue;
                for (int j = i + 1; j < m; j++) {
                    if ((mask & (1 << j)) != 0) continue;
                    int newMask = mask | (1 << i) | (1 << j);
                    int score = dp[mask] + op * gcd[i][j];
                    dp[newMask] = Math.max(dp[newMask], score);
                }
            }
        }
        
        // fullMask uses all elements
        return dp[maxMask - 1];
    }
    
    // Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
