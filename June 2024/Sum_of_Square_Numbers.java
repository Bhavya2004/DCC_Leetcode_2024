class Solution {
    public boolean judgeSquareSum(int c) {
         for (long a = 0; a * a <= c; a++) {
            int b = c - (int) (a * a);
            int sqrt = (int) Math.sqrt(b);
            if (sqrt * sqrt == b) {
                return true;
            }
        }
        return false;
    }
}