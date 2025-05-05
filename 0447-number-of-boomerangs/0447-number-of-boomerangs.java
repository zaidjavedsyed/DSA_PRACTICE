import java.util.*;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;

        for (int[] p1 : points) {
            Map<Integer, Integer> map = new HashMap<>(); // distance^2 → frequency

            for (int[] p2 : points) {
                int dx = p1[0] - p2[0];
                int dy = p1[1] - p2[1];
                int dist = dx * dx + dy * dy;

                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }

            for (int freq : map.values()) {
                count += freq * (freq - 1); // permutations of j and k
            }
        }

        return count;
    }
}
