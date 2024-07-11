class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(sb.length());
            } else if (c == ')') {
                int start = stack.pop();
                int end = sb.length() - 1;
                reverse(sb, start, end);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
     public static void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}