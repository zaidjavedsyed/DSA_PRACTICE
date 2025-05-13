class Solution {
    public int minFlips(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // Encode initial matrix as bitmask
        int start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    start |= 1 << (i * n + j);
                }
            }
        }
        
        // Precompute, for each cell idx, the bitmask of that cell + its 4-neighbors
        int total = m * n;
        int[] flipMask = new int[total];
        int[][] dirs = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                int mask = 0;
                for (int[] d : dirs) {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        mask |= 1 << (ni * n + nj);
                    }
                }
                flipMask[idx] = mask;
            }
        }
        
        // BFS
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] seen = new boolean[1 << total];
        q.offer(start);
        seen[start] = true;
        int steps = 0;
        
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int cur = q.poll();
                if (cur == 0) return steps;  // reached zero matrix!
                // try flipping each cell
                for (int idx = 0; idx < total; idx++) {
                    int next = cur ^ flipMask[idx];
                    if (!seen[next]) {
                        seen[next] = true;
                        q.offer(next);
                    }
                }
            }
            steps++;
        }
        
        return -1;  // unreachable
    }
}
