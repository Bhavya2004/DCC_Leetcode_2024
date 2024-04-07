class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen = Math.max(minOpen - 1, 0);
                maxOpen--;
                if (maxOpen < 0) {
                    return false;
                }
            } else if (c == '*') {
                minOpen = Math.max(minOpen - 1, 0);
                maxOpen++;
            }
        }

        return minOpen == 0;
    }
}