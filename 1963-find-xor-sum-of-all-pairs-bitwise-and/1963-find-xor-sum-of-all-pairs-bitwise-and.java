public class Solution {
    /**
     * Returns the XOR sum of all arr1[i] & arr2[j] over all pairs (i, j).
     * Key fact: For each bit position k, that bit in the final XOR is 1
     * iff the number of 1s in arr1 at k is odd AND the number of 1s in arr2 at k is odd.
     * Hence the result is simply (xor of all arr1) & (xor of all arr2).
     */
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1 = 0, xor2 = 0;
        for (int v : arr1) xor1 ^= v;
        for (int v : arr2) xor2 ^= v;
        return xor1 & xor2;
    }
}
