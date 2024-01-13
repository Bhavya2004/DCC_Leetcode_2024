class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26]; 
    
    for (char c : s.toCharArray()) {
        freq[c - 'a']++;
    }
    
   for (char c : t.toCharArray()) {
        freq[c - 'a']--;
    }
    
    int steps = 0;
    
    for (int f : freq) {
        steps += Math.abs(f);
    }
    
    return steps / 2;
    }
}