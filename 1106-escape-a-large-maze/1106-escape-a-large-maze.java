class Solution {
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    private static final int BOUND = 1_000_000;
    
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        // Maximum number of cells that blocked points can enclose:
        // b * (b - 1) / 2
        int b = blocked.length;
        long maxExplore = (long)b * (b - 1) / 2;
        
        // Put blocked cells into a hash set for O(1) lookups
        Set<Long> blockedSet = new HashSet<>();
        for (int[] p : blocked) {
            blockedSet.add(encode(p[0], p[1]));
        }
        
        // If neither source nor target is enclosed, path exists
        return reachable(source, target, blockedSet, maxExplore)
            && reachable(target, source, blockedSet, maxExplore);
    }
    
    // Try to BFS from start toward end. 
    // Return true if we either reach 'end' or we explore more than maxExplore cells
    // (which implies we're not enclosed by the blocked cells).
    private boolean reachable(int[] start, int[] end, Set<Long> blockedSet, long maxExplore) {
        Set<Long> seen = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        seen.add(encode(start[0], start[1]));
        
        while (!queue.isEmpty() && seen.size() <= maxExplore) {
            int[] cur = queue.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) {
                // We found the target!
                return true;
            }
            for (int[] d : DIRS) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr < 0 || nr >= BOUND || nc < 0 || nc >= BOUND) continue;
                long code = encode(nr, nc);
                if (blockedSet.contains(code) || seen.contains(code)) continue;
                seen.add(code);
                queue.offer(new int[]{nr, nc});
            }
        }
        // If we've exceeded maxExplore without hitting a wall of blocked cells,
        // we're free to roam → not enclosed.
        return seen.size() > maxExplore;
    }
    
    // Encode a coordinate pair into a single long
    private long encode(int r, int c) {
        return ((long)r << 20) | c;
    }
}
