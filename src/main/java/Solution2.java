public class Solution2 implements Solution {
    @Override
    public int divide(int dividend, int divisor) {
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }

        boolean isNeg = true;
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            isNeg = false;
        }

        long dividend_abs = Math.abs((long)dividend);
        long divisor_abs = Math.abs((long)divisor);

        int result = 0;
        while (dividend_abs >= divisor_abs) {
            int i = 0;
            while ((divisor_abs << i) <= dividend_abs) {
                i++;
            }
            if (i > 0) {
                result += 1<<(i-1);
                dividend_abs -= divisor_abs<<(i-1);
            }
        }

        return isNeg ? -result : result;
    }
}
