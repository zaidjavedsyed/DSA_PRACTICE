class Solution {
    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;
        // compute total sum
        long total = 0;
        for (int x : nums) total += x;
        // prefix sum as we go, and key1 array for pivots 1..n-1
        long[] key1 = new long[n];
        long pref = 0;
        for (int i = 1; i < n; i++) {
            pref += nums[i-1];
            key1[i] = 2 * pref - total;
        }
        
        // Build rightCount: keys for pivots i=1..n-1
        Map<Long, Integer> rightCount = new HashMap<>();
        for (int i = 1; i < n; i++) {
            rightCount.put(key1[i], rightCount.getOrDefault(key1[i], 0) + 1);
        }
        Map<Long, Integer> leftCount = new HashMap<>();
        
        // ans0 = ways without any change (Δ=0)
        int ans = rightCount.getOrDefault(0L, 0);
        
        // Sweep j = 0..n-1
        pref = 0;
        for (int j = 0; j < n; j++) {
            long delta = (long)k - nums[j];
            int ways = leftCount.getOrDefault(delta, 0)
                     + rightCount.getOrDefault(-delta, 0);
            ans = Math.max(ans, ways);
            
            // move pivot i = j+1 from rightCount -> leftCount
            int i = j + 1;
            if (i < n) {
                long key = key1[i];
                // decrement in rightCount
                int rc = rightCount.get(key);
                if (rc == 1) rightCount.remove(key);
                else          rightCount.put(key, rc - 1);
                // increment in leftCount
                leftCount.put(key, leftCount.getOrDefault(key, 0) + 1);
            }
        }
        
        return ans;
    }
}
