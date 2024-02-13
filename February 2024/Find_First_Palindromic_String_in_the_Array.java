class Solution {
    public String firstPalindrome(String[] words) {
         for (String word : words) {
            if (isPalindromic(word)) {
                return word;
            }
        }
        return "";
    }
    public static boolean isPalindromic(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}