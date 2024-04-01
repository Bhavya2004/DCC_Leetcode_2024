class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        
        // Find the last space in the trimmed string
        int lastSpaceIndex = s.lastIndexOf(' ');
        
        // If there is no space, return the length of the whole string
        if (lastSpaceIndex == -1) {
            return s.length();
        }
        
        // Return the length of the last word
        return s.length() - lastSpaceIndex - 1;

    }
}