class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // exactly K = atMost(K) − atMost(K − 1)
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    // Count subarrays with ≤ K distinct
    private int atMost(int[] nums, int K) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, result = 0, distinct = 0;
        
        for (int right = 0; right < n; right++) {
            int x = nums[right];
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            if (freq.get(x) == 1) {
                // new distinct integer
                distinct++;
            }
            
            // shrink window until we have ≤ K distinct
            while (distinct > K) {
                int y = nums[left++];
                freq.put(y, freq.get(y) - 1);
                if (freq.get(y) == 0) {
                    freq.remove(y);
                    distinct--;
                }
            }
            
            // all subarrays ending at `right` and starting anywhere in [left..right]
            // are valid (since they have ≤ K distinct)
            result += right - left + 1;
        }
        
        return result;
    }
}
