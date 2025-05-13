class Solution {
    public int longestAwesome(String s) {
        int n = s.length();
        // earliest index we saw each mask; 2^10 = 1024 possible masks
        int[] firstIdx = new int[1 << 10];
        Arrays.fill(firstIdx, Integer.MAX_VALUE);
        firstIdx[0] = -1;  // empty prefix has mask=0 at index -1
        
        int mask = 0, ans = 0;
        for (int j = 0; j < n; j++) {
            int d = s.charAt(j) - '0';
            // flip parity of digit d
            mask ^= 1 << d;
            
            // Case 1: substring [firstIdx[mask]+1 .. j] has zero bits set
            if (firstIdx[mask] != Integer.MAX_VALUE) {
                ans = Math.max(ans, j - firstIdx[mask]);
            } else {
                // record first time we see this mask
                firstIdx[mask] = j;
            }
            
            // Case 2: exactly one odd digit allowed
            for (int k = 0; k < 10; k++) {
                int m2 = mask ^ (1 << k);
                if (firstIdx[m2] != Integer.MAX_VALUE) {
                    ans = Math.max(ans, j - firstIdx[m2]);
                }
            }
        }
        
        return ans;
    }
}
