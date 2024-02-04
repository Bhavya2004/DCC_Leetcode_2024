class Solution {
    public String minWindow(String s, String t) {
        int[] tFreq = new int[128];
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }

        int left = 0;
        int right = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
    
        // Move the right pointer to find a valid window
        while (right < s.length()) {
            char c = s.charAt(right);
            if (tFreq[c] > 0) {
                count--;
            }
            tFreq[c]--;
            right++;
        
        // Move the left pointer to minimize the window size
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }
            
                char leftChar = s.charAt(left);
                tFreq[leftChar]++;
                if (tFreq[leftChar] > 0) {
                    count++;
                }
                left++;
            }
        }
    
    // Return the minimum window substring
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
        }
}