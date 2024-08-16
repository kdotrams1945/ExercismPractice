package Leet.DivT;
//TODO:IMPORTANT Understand how to spEed up from samples.
public class Solution {
    public int divide(int dividend, int divisor) {

        int result = 0;
        if (divisor == 0) {
            throw new ArithmeticException();
        }
        if (dividend == 0) {
            return result;
        }
        if (divisor == 1){
            return dividend;
        }
        if (divisor == -1){
            if (dividend == Integer.MIN_VALUE)
            {
                return Integer.MAX_VALUE;
            }
            else
            {
                return dividend * -1;
            }
        }

        long posDividend =  Math.abs((long)dividend);
        long posDivisor = Math.abs((long)divisor);
        while (posDividend > 0 && posDividend >= posDivisor) {
            posDividend -= posDivisor;
            result++;
        }

        boolean isOnlyOneNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        if (isOnlyOneNegative) {
            result *= -1;
        }


        return result;
    }


}
