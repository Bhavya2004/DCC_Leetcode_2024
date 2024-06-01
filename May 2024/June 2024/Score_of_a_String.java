class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 1; i < s.length(); i++) {
            int diff = Math.abs(s.charAt(i) - s.charAt(i - 1));
            score += diff;
        }
        return score;
    }
}