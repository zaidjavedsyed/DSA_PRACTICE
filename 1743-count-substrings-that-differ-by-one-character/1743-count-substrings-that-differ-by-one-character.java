class Solution {
    public int countSubstrings(String s, String t) {
        int n = s.length(), m = t.length();
        int result = 0;
        // Try every starting pair (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int mismatches = 0;
                // Extend substring length k
                for (int k = 0; i + k < n && j + k < m; k++) {
                    if (s.charAt(i + k) != t.charAt(j + k)) {
                        mismatches++;
                    }
                    if (mismatches == 1) {
                        result++;
                    } else if (mismatches > 1) {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
