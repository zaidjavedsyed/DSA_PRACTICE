class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        // Maps to track how many lamps illuminate each row, col, diag, anti-diag
        Map<Integer, Integer> rowCount = new HashMap<>();
        Map<Integer, Integer> colCount = new HashMap<>();
        Map<Integer, Integer> diagCount = new HashMap<>();
        Map<Integer, Integer> antiDiagCount = new HashMap<>();
        // Set of “on” lamps, encoded as (r << 32) | c
        Set<Long> onLamps = new HashSet<>();
        
        // Helper to add/subtract counts
        BiConsumer<Map<Integer,Integer>, Integer> inc = (m, key) ->
            m.put(key, m.getOrDefault(key, 0) + 1);
        BiConsumer<Map<Integer,Integer>, Integer> dec = (m, key) -> {
            int v = m.getOrDefault(key, 0) - 1;
            if (v <= 0) m.remove(key);
            else        m.put(key, v);
        };
        
        // Turn on initial lamps
        for (int[] lamp : lamps) {
            int r = lamp[0], c = lamp[1];
            long code = (((long)r) << 32) | c;
            if (!onLamps.add(code)) continue;  // duplicate lamp – skip
            inc.accept(rowCount,    r);
            inc.accept(colCount,    c);
            inc.accept(diagCount,   r - c);
            inc.accept(antiDiagCount, r + c);
        }
        
        int m = queries.length;
        int[] ans = new int[m];
        int idx = 0;
        
        // Directions for the lamp-off step (self + 8 neighbors)
        int[] dr = {-1,-1,-1, 0,0, 1,1,1, 0};
        int[] dc = {-1, 0, 1,-1,1,-1,0,1, 0};
        
        for (int[] q : queries) {
            int r = q[0], c = q[1];
            // If any of row/col/diag/anti-diag counts > 0, it's illuminated
            boolean illuminated =
                rowCount.containsKey(r) ||
                colCount.containsKey(c) ||
                diagCount.containsKey(r - c) ||
                antiDiagCount.containsKey(r + c);
            ans[idx++] = illuminated ? 1 : 0;
            
            // Turn off lamp at (r,c) and its 8 neighbors
            for (int k = 0; k < 9; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                long code = (((long)nr) << 32) | nc;
                if (onLamps.remove(code)) {
                    // decrement all four illumination maps
                    dec.accept(rowCount,    nr);
                    dec.accept(colCount,    nc);
                    dec.accept(diagCount,   nr - nc);
                    dec.accept(antiDiagCount, nr + nc);
                }
            }
        }
        
        return ans;
    }
}
