class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        
        for (int i = s.length() - 1; i > 0; i--) {
            int digit = s.charAt(i) - '0';
            
            if (digit + carry == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps += 1;
                carry = digit;
            }
        }
        
        return steps + carry;
    }
}