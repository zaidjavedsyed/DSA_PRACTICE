public class Solution {
    private static final int MOD = 1_000_000_007;

    public int maxNiceDivisors(int primeFactors) {
        // We want to maximize the product of (e_i + 1)
        // subject to sum(e_i) = primeFactors.
        // It can be shown the optimal is to split into as many 3's as possible,
        // with a remainder of 2 or 4 (i.e. replace a 3+1 by 2+2).
        if (primeFactors == 1) return 1;

        long count3 = primeFactors / 3;
        int rem = primeFactors % 3;
        if (rem == 1) {
            // Better to take one 3 back and make 4 = 2+2
            count3 -= 1;
            rem = 4;
        }
        long count2 = rem / 2;

        long res = modPow(3, count3);
        res = (res * modPow(2, count2)) % MOD;
        return (int) res;
    }

    // Fast exponentiation modulo MOD
    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}
