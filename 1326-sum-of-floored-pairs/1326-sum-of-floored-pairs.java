public class Solution {
    private static final int MOD = 1_000_000_007;

    public int sumOfFlooredPairs(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int v : nums) {
            if (v > max) max = v;
        }

        // frequency array
        int[] freq = new int[max + 1];
        for (int v : nums) {
            freq[v]++;
        }

        // prefix sums of frequencies
        int[] prefix = new int[max + 1];
        prefix[0] = 0;
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + freq[i];
        }

        long ans = 0;
        // For each possible divisor value d (nums[j])
        for (int d = 1; d <= max; d++) {
            int f = freq[d];
            if (f == 0) continue;
            // For each quotient k such that k*d <= max
            for (int k = 1, start = d; start <= max; k++, start += d) {
                int end = Math.min(start + d - 1, max);
                int cnt = prefix[end] - prefix[start - 1];
                // add k * freq[d] * cnt
                ans = (ans + (long)k * f % MOD * cnt) % MOD;
            }
        }

        return (int)ans;
    }
}
