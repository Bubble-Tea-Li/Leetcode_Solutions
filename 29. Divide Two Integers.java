class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int res = 0;
        int dividendAbs = Math.abs(dividend);
        int divisorAbs = Math.abs(divisor);
        // should not use dividendAbs >= divisorAbs for overflow problem.
        // Math.abs(Integer.MIN_VALUE) = Integer.MIN_VALUE
        // Integer.MIN_VALUE - 1 = Integer.MAX_VALUE >= 0
        // But, Integer.MIN_VALUE < 0 < 1
        while (dividendAbs - divisorAbs >= 0) {
            int temp = divisorAbs;
            int count = 1;
            while (dividendAbs - (temp << 1) >= 0) {
                temp <<= 1;
                count <<= 1;
            }
            dividendAbs -= temp;
            res += count;
        }
        return ((dividend > 0) == (divisor > 0)) ? res : -res;
    }
}