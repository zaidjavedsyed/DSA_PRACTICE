import java.util.ArrayList;
import java.util.List;

class UnionFind {
    private final int[] parent;
    private final int[] rank;

    public UnionFind(int n) {
        parent = new int[n + 1];
        rank   = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i]   = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx == ry) return;
        if (rank[rx] < rank[ry]) {
            parent[rx] = ry;
        } else if (rank[ry] < rank[rx]) {
            parent[ry] = rx;
        } else {
            parent[ry] = rx;
            rank[rx]++;
        }
    }
}

public class Solution {
    /**
     * Returns a List<Boolean> indicating for each query whether
     * the two cities are connected (directly or indirectly).
     */
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        UnionFind uf = new UnionFind(n);

        // Union cities sharing any divisor > threshold
        for (int d = threshold + 1; d <= n; d++) {
            for (int multiple = 2 * d; multiple <= n; multiple += d) {
                uf.union(d, multiple);
            }
        }

        List<Boolean> answer = new ArrayList<>(queries.length);
        for (int[] q : queries) {
            answer.add(uf.find(q[0]) == uf.find(q[1]));
        }
        return answer;
    }
}
