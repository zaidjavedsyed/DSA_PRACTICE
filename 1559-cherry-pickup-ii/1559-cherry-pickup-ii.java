class Solution {
    private int rows, cols;
    private int[][][] memo;
    private int[][] grid;
    private static final int NEG_INF = -1000000000;
    private final int[] DIR = {-1, 0, 1};

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.memo = new int[rows][cols][cols];
        for (int r = 0; r < rows; r++) {
            for (int c1 = 0; c1 < cols; c1++) {
                Arrays.fill(memo[r][c1], Integer.MIN_VALUE);
            }
        }
        return dp(0, 0, cols - 1);
    }

    // dp(r, c1, c2) = max cherries from row r to bottom,
    // when robot1 is at (r, c1) and robot2 at (r, c2)
    private int dp(int r, int c1, int c2) {
        // out of bounds
        if (c1 < 0 || c1 >= cols || c2 < 0 || c2 >= cols) {
            return NEG_INF;
        }
        // memoized
        if (memo[r][c1][c2] != Integer.MIN_VALUE) {
            return memo[r][c1][c2];
        }
        // collect cherries at current row
        int cherries = grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);
        // if last row, we're done
        if (r == rows - 1) {
            return memo[r][c1][c2] = cherries;
        }
        int maxNext = NEG_INF;
        // try all moves for both robots
        for (int d1 : DIR) {
            for (int d2 : DIR) {
                int nc1 = c1 + d1;
                int nc2 = c2 + d2;
                maxNext = Math.max(maxNext, dp(r + 1, nc1, nc2));
            }
        }
        return memo[r][c1][c2] = cherries + maxNext;
    }
}
