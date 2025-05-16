class Solution {
    private static final int INF = Integer.MAX_VALUE / 2;

    public int minimumDistance(String word) {
        int n = word.length();
        // dp[i][j]: min cost after typing processed chars,
        // with finger1 at i and finger2 at j (0–25 for 'A'–'Z', 26 = unused)
        int[][] dp = new int[27][27];
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                dp[i][j] = INF;
            }
        }
        // start with both fingers unused
        dp[26][26] = 0;

        for (int k = 0; k < n; k++) {
            int c = word.charAt(k) - 'A';
            int[][] newDp = new int[27][27];
            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    newDp[i][j] = INF;
                }
            }

            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    int cost = dp[i][j];
                    if (cost >= INF) continue;
                    // move finger1 to c
                    int move1 = cost + dist(i, c);
                    newDp[c][j] = Math.min(newDp[c][j], move1);
                    // move finger2 to c
                    int move2 = cost + dist(j, c);
                    newDp[i][c] = Math.min(newDp[i][c], move2);
                }
            }
            dp = newDp;
        }

        // find minimum over all end states
        int ans = INF;
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                ans = Math.min(ans, dp[i][j]);
            }
        }
        return ans;
    }

    // Manhattan distance on the 6×5 keyboard grid,
    // with positions 0–25 = 'A'–'Z', 26 = unused (cost 0 to move from unused)
    private int dist(int x, int y) {
        if (x == 26 || y == 26) return 0;
        int xR = x / 6, xC = x % 6;
        int yR = y / 6, yC = y % 6;
        return Math.abs(xR - yR) + Math.abs(xC - yC);
    }
}
