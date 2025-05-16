import java.util.Arrays;

class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int n = arr1.length;
        Arrays.sort(arr2);
        // dp[k] = the minimum possible tail value of a strictly increasing sequence
        // formed from arr1[0..i] with exactly k replacements.
        // Initialize dp: dp[0] = -inf (no elements → tail = -inf), others = +inf
        final int INF = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = -INF;
        
        for (int x : arr1) {
            int[] newDp = new int[n + 1];
            Arrays.fill(newDp, INF);
            for (int k = 0; k <= n; k++) {
                if (dp[k] == INF) continue;
                // Option 1: keep x (no replacement)
                if (x > dp[k]) {
                    newDp[k] = Math.min(newDp[k], x);
                }
                // Option 2: replace x with the smallest arr2[j] > dp[k]
                int idx = Arrays.binarySearch(arr2, dp[k] + 1);
                if (idx < 0) idx = -idx - 1;
                if (idx < arr2.length && k + 1 <= n) {
                    newDp[k + 1] = Math.min(newDp[k + 1], arr2[idx]);
                }
            }
            dp = newDp;
        }
        
        // Find the smallest k for which dp[k] < +INF
        for (int k = 0; k <= n; k++) {
            if (dp[k] < INF) return k;
        }
        return -1;
    }
}
