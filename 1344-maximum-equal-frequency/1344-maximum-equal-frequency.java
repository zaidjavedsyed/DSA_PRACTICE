class Solution {
    public int maxEqualFreq(int[] nums) {
        int n = nums.length;
        // freq[x] = current frequency of number x
        Map<Integer, Integer> freq = new HashMap<>();
        // cnt[f] = how many numbers have frequency f
        Map<Integer, Integer> cnt = new HashMap<>();
        
        int maxF = 0;       // maximum frequency seen so far
        int distinct = 0;   // how many distinct numbers so far
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            
            // remove old frequency
            int oldF = freq.getOrDefault(x, 0);
            if (oldF > 0) {
                cnt.put(oldF, cnt.get(oldF) - 1);
                if (cnt.get(oldF) == 0) cnt.remove(oldF);
            } else {
                distinct++;
            }
            
            // increment to new frequency
            int newF = oldF + 1;
            freq.put(x, newF);
            cnt.put(newF, cnt.getOrDefault(newF, 0) + 1);
            
            // update maxF
            maxF = Math.max(maxF, newF);
            
            int length = i + 1;  // current prefix length
            
            // Check the three valid patterns:
            boolean valid =
                // 1) all freq=1
                (maxF == 1)
                
                // 2) one freq=1, all others freq=maxF
                || (cnt.getOrDefault(1, 0) == 1
                    && cnt.get(maxF) * maxF + 1 == length)
                
                // 3) one freq=maxF, all others freq=maxF-1
                || (cnt.getOrDefault(maxF, 0) == 1
                    && cnt.getOrDefault(maxF - 1, 0) * (maxF - 1) + maxF == length);
            
            if (valid) {
                ans = length;
            }
        }
        
        return ans;
    }
}
