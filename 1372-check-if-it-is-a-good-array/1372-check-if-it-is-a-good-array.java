public class Solution {
    /** 
     * Returns true iff we can form 1 as an integer combination
     * of the elements in nums—i.e., iff their gcd is 1.
     */
    public boolean isGoodArray(int[] nums) {
        int g = nums[0];
        for (int i = 1; i < nums.length; i++) {
            g = gcd(g, nums[i]);
            // Early exit if gcd already 1
            if (g == 1) {
                return true;
            }
        }
        return g == 1;
    }

    /** Compute gcd of a and b using the Euclidean algorithm. */
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
