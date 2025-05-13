class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];  // keys 11,12,…,19,22,23,…,99
        int ans = 0;
        
        for (int[] d : dominoes) {
            int a = d[0], b = d[1];
            // normalize so smaller digit comes first
            int key = (a < b) ? (a * 10 + b) : (b * 10 + a);
            // any previous domino with the same key forms a pair
            ans += count[key];
            // record this one for future pairs
            count[key]++;
        }
        
        return ans;
    }
}
