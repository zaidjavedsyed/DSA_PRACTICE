class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean sign = (dividend < 0) == (divisor < 0); // true if both have the same sign

        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        long ans = 0;

        while (ldividend >= ldivisor) {
            int count = 0;
            while (ldividend >= (ldivisor << (count + 1)) && (ldivisor << (count + 1)) > 0) { // Prevent overflow
                count++;
            }
            ans += 1L << count;
            ldividend -= ldivisor << count;
        }

        if (ans > Integer.MAX_VALUE) {
            return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return sign ? (int) ans : (int) -ans;
    }
}
