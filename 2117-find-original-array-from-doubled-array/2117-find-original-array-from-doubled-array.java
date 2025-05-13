class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if ((n & 1) == 1) return new int[0];
        
        // 1) frequency map
        Map<Integer,Integer> freq = new HashMap<>();
        for (int x : changed)
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        
        // 2) sort keys
        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);
        
        int[] original = new int[n/2];
        int idx = 0;
        
        for (int x : keys) {
            int count = freq.getOrDefault(x, 0);
            if (count == 0) continue;
            
            if (x == 0) {
                // zeros pair among themselves: need an even count
                if ((count & 1) == 1) return new int[0];
                int pairs = count / 2;
                for (int i = 0; i < pairs; i++) {
                    original[idx++] = 0;
                }
                // mark as used
                freq.put(0, 0);
            } else {
                int need = freq.getOrDefault(2*x, 0);
                if (need < count) return new int[0];
                // consume the doubles
                freq.put(2*x, need - count);
                // append x count times
                for (int i = 0; i < count; i++) {
                    original[idx++] = x;
                }
                freq.put(x, 0);
            }
        }
        
        return original;
    }
}
