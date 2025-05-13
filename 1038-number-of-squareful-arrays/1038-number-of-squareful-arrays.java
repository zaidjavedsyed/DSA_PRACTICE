class Solution {
    private int ans = 0;
    
    public int numSquarefulPerms(int[] nums) {
        int n = nums.length;
        // Count how many times each value appears
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        
        // Build adjacency: for each distinct x, list all distinct y (including x itself)
        // such that x + y is a perfect square.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> unique = new ArrayList<>(count.keySet());
        for (int x : unique) {
            graph.put(x, new ArrayList<>());
        }
        for (int i = 0; i < unique.size(); i++) {
            for (int j = i; j < unique.size(); j++) {
                int x = unique.get(i), y = unique.get(j);
                if (isSquare(x + y)) {
                    graph.get(x).add(y);
                    if (x != y) graph.get(y).add(x);
                }
            }
        }
        
        // Try each distinct number as the starting element
        for (int x : unique) {
            backtrack(x, 1, n, count, graph);
        }
        
        return ans;
    }
    
    private void backtrack(int last, int length, int n,
                           Map<Integer, Integer> count,
                           Map<Integer, List<Integer>> graph) {
        // use one 'last'
        count.put(last, count.get(last) - 1);
        
        if (length == n) {
            ans++;
        } else {
            // explore neighbors that can follow 'last'
            for (int nei : graph.get(last)) {
                if (count.get(nei) > 0) {
                    backtrack(nei, length + 1, n, count, graph);
                }
            }
        }
        
        // undo
        count.put(last, count.get(last) + 1);
    }
    
    private boolean isSquare(int x) {
        int r = (int)Math.sqrt(x);
        return r * r == x;
    }
}
