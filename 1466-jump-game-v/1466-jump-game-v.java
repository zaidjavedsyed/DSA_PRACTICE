import java.util.Arrays;

class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dfs(i, arr, d, dp));
        }
        return result;
    }
    
    private int dfs(int i, int[] arr, int d, int[] dp) {
        if (dp[i] != -1) return dp[i];
        int n = arr.length;
        int best = 1;  // at least you stay at i
        // jump to the left
        for (int j = i - 1; j >= 0 && j >= i - d; j--) {
            if (arr[j] >= arr[i]) break;
            best = Math.max(best, 1 + dfs(j, arr, d, dp));
        }
        // jump to the right
        for (int j = i + 1; j < n && j <= i + d; j++) {
            if (arr[j] >= arr[i]) break;
            best = Math.max(best, 1 + dfs(j, arr, d, dp));
        }
        return dp[i] = best;
    }
}
