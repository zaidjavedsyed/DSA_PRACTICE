public class Solution {
    // Precompute nCr up to 30 choose 30
    private static final int MAX = 30;
    private final long[][] comb = new long[MAX + 1][MAX + 1];

    public Solution() {
        // Pascal's triangle
        for (int n = 0; n <= MAX; n++) {
            comb[n][0] = comb[n][n] = 1;
            for (int r = 1; r < n; r++) {
                comb[n][r] = comb[n - 1][r - 1] + comb[n - 1][r];
            }
        }
    }

    public String kthSmallestPath(int[] destination, int k) {
        int V = destination[0]; // number of 'V' (down) moves
        int H = destination[1]; // number of 'H' (right) moves

        StringBuilder sb = new StringBuilder(V + H);
        while (H > 0 || V > 0) {
            if (H == 0) {
                // only V's remain
                sb.append('V');
                V--;
            } else if (V == 0) {
                // only H's remain
                sb.append('H');
                H--;
            } else {
                // count of sequences starting with 'H'
                // = choose( (H-1) + V, H-1 )
                long countH = comb[H - 1 + V][H - 1];
                if (k <= countH) {
                    sb.append('H');
                    H--;
                } else {
                    sb.append('V');
                    V--;
                    k -= countH;
                }
            }
        }
        return sb.toString();
    }
}
