public class Solution {
    public int longestDecomposition(String text) {
        return decompose(text, 0, text.length() - 1);
    }

    private int decompose(String s, int left, int right) {
        if (left > right) return 0;
        // Try all possible chunk lengths
        for (int len = 1; left + len - 1 < right - len + 1; len++) {
            // Compare s[left..left+len-1] with s[right-len+1..right]
            if (s.substring(left, left + len)
                 .equals(s.substring(right - len + 1, right + 1))) {
                // Found matching chunk: count 2 and recurse on the middle
                return 2 + decompose(s, left + len, right - len);
            }
        }
        // No further decomposition: the middle remainder is one chunk
        return 1;
    }
}
