class Solution 
{
    public int divide(int dividend, int divisor) 
    {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        int quotient = 0;

        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                a -= b << i;
                quotient |= (1 << i);
            }
        }

        return ((dividend < 0) ^ (divisor < 0)) ? -quotient : quotient;
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println("The quotient of 43/5 is "+s.divide(43,5));
        System.out.println("The quotient of -15/4 is "+s.divide(-15,4));
    }
}