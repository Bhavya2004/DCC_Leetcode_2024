class Solution {
    public static int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char ch = s.charAt(left);
            while (left <= right && s.charAt(left) == ch) {
                left++;
            }
            while (left <= right && s.charAt(right) == ch) {
                right--;
            }
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        String s = "abccba";
        int minLength = minimumLength(s);
        System.out.println("Minimum length of s: " + minLength);
    }
}