class Solution {
    public boolean halvesAreAlike(String s) {
        int countA = 0;
        int countB = 0;
        int mid = s.length() / 2;
        
        for (int i = 0; i < mid; i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                countA++;
            }
        }
        
        for (int i = mid; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                countB++;
            }
        }
        
        return countA == countB;
    }
}