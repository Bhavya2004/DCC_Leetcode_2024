class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        
        if (words == null || words.length == 0) {
            return result;
        }
        
        int[] charCount = new int[26];
        
        for (char c : words[0].toCharArray()) {
            charCount[c - 'a']++;
        }
        
        for (int i = 1; i < words.length; i++) {
            int[] tempCount = new int[26];
            
            for (char c : words[i].toCharArray()) {
                tempCount[c - 'a']++;
            }
            
            for (int j = 0; j < 26; j++) {
                charCount[j] = Math.min(charCount[j], tempCount[j]);
            }
        }
        
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < charCount[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        
        return result;
    }
}