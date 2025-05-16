class Solution {
    public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length;
        int maxMask = 1 << n;
        // Precompute valid seat-masks for each row
        List<Integer>[] validMasks = new List[m];
        for (int i = 0; i < m; i++) {
            validMasks[i] = new ArrayList<>();
            for (int mask = 0; mask < maxMask; mask++) {
                if (isValid(mask, seats[i], n)) {
                    validMasks[i].add(mask);
                }
            }
        }
        // dp[row][mask] = max students up to row using mask on this row
        int[][] dp = new int[m][maxMask];
        // Initialize first row
        for (int mask : validMasks[0]) {
            dp[0][mask] = Integer.bitCount(mask);
        }
        // Fill DP for rows 1..m-1
        for (int i = 1; i < m; i++) {
            for (int mask : validMasks[i]) {
                int cnt = Integer.bitCount(mask);
                for (int pm : validMasks[i - 1]) {
                    // no diagonal conflicts with previous row
                    if ((mask & (pm << 1)) == 0 && (mask & (pm >> 1)) == 0) {
                        dp[i][mask] = Math.max(dp[i][mask], dp[i - 1][pm] + cnt);
                    }
                }
            }
        }
        // Find the best over the last row
        int ans = 0;
        for (int mask : validMasks[m - 1]) {
            ans = Math.max(ans, dp[m - 1][mask]);
        }
        return ans;
    }
    
    // Check mask is compatible with the row layout and has no adjacent bits
    private boolean isValid(int mask, char[] row, int n) {
        // 1) mask must only place students on '.'
        for (int j = 0; j < n; j++) {
            if (((mask >> j) & 1) == 1 && row[j] == '#') {
                return false;
            }
        }
        // 2) no two students adjacent in the same row
        if ((mask & (mask << 1)) != 0) {
            return false;
        }
        return true;
    }
}
