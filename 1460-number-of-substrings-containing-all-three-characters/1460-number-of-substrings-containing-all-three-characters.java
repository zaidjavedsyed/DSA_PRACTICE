class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        // last seen positions, initialize to -1
        int lastA = -1, lastB = -1, lastC = -1;
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') lastA = i;
            else if (ch == 'b') lastB = i;
            else /* ch == 'c' */ lastC = i;
            
            // Earliest index among lastA, lastB, lastC:
            int minLast = Math.min(lastA, Math.min(lastB, lastC));
            if (minLast >= 0) {
                // Any substring ending at i that starts at [0..minLast]
                // will include all three at least once
                ans += (minLast + 1);
            }
        }
        
        return ans;
    }
}
