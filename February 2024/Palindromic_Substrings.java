class Solution {
    public int countSubstrings(String s) {
         int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindromes(s, i, i); // odd length palindromes
            count += countPalindromes(s, i, i + 1); // even length palindromes
        }
        return count;
    }
    public int countPalindromes(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}