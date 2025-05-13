class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        // Pair up (value, label)
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = values[i];
            items[i][1] = labels[i];
        }
        // Sort descending by value
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        
        Map<Integer, Integer> used = new HashMap<>();
        int taken = 0, sum = 0;
        
        for (int[] item : items) {
            if (taken == numWanted) break;
            int val = item[0], lab = item[1];
            int cnt = used.getOrDefault(lab, 0);
            if (cnt < useLimit) {
                sum += val;
                taken++;
                used.put(lab, cnt + 1);
            }
        }
        
        return sum;
    }
}
