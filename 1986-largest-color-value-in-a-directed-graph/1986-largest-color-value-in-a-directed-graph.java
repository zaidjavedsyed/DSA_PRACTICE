class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        // build graph + in‐degrees
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }
        
        // dp[node][c] = max count of color 'a'+c along any path ending at node
        int[][] dp = new int[n][26];
        Queue<Integer> q = new ArrayDeque<>();
        
        // start with nodes of indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        
        int seen = 0, answer = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            seen++;
            // incorporate this node's own color
            int c = colors.charAt(u) - 'a';
            dp[u][c]++;
            // update global answer with best at this node
            for (int k = 0; k < 26; k++) {
                answer = Math.max(answer, dp[u][k]);
            }
            
            // push forward to neighbors
            for (int v : graph.get(u)) {
                // relax dp: for each color, propagate the maximum seen so far
                for (int k = 0; k < 26; k++) {
                    dp[v][k] = Math.max(dp[v][k], dp[u][k]);
                }
                // decrease indegree
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        
        // if we didn't process all nodes, there's a cycle
        return (seen == n ? answer : -1);
    }
}
