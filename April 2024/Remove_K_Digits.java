class Solution {
    public String removeKdigits(String num, int k) {
               // Create a stack to store the digits
        Stack<Character> stack = new Stack<>();

        // Iterate through each digit in the num string
        for (char digit : num.toCharArray()) {
            // Remove digits from the stack until the current digit is greater than the top of the stack
            while (!stack.isEmpty() && k > 0 && digit < stack.peek()) {
                stack.pop();
                k--;
            }
            // Push the current digit onto the stack
            stack.push(digit);
        }

        // Remove any remaining digits from the stack to satisfy the k requirement
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build the resulting string from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        // Remove leading zeros from the resulting string
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // If all digits are removed, return "0"
        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }
}