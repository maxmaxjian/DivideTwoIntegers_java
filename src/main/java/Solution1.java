public class Solution1 implements Solution {
    @Override
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }

        boolean isNeg = true;
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            isNeg = false;
        }

        int dividend_abs = -Math.abs(dividend);
        int divisor_abs = Math.abs(divisor);
        int i_before = 1, result_before = -divisor_abs;
        int i_after = i_before+i_before, result_after = result_before+result_before;
        while (result_after >= dividend_abs) {
            result_before = result_after;
            i_before = i_after;
            result_after = result_before+result_before;
            i_after = i_before+i_before;
            if (result_after >= 0) {
                break;
            }
        }

        int i = i_before, result = result_before;
        while (result >= dividend_abs) {
            result -= divisor_abs;
            i++;
            if (result > 0) {
                break;
            }
        }

        return isNeg ? -(i-1) : i-1;
    }
}
