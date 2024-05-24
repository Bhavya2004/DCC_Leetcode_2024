class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letterFreq = new int[26];
        for (char letter : letters) {
            letterFreq[letter - 'a']++;
        }
        
        return findMaxScore(words, letterFreq, score, 0);
    }
    public int findMaxScore(String[] words, int[] letterFreq, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }
       
        int[] tempFreq = Arrays.copyOf(letterFreq, letterFreq.length);
        boolean canFormWord = true;
        int currScore = 0;
        for (char letter : words[index].toCharArray()) {
            if (tempFreq[letter - 'a'] == 0) {
                canFormWord = false;
                break;
            }
            tempFreq[letter - 'a']--;
            currScore += score[letter - 'a'];
        }
        int maxScore = findMaxScore(words, letterFreq, score, index + 1);
        if (canFormWord) {
            maxScore = Math.max(maxScore, currScore + findMaxScore(words, tempFreq, score, index + 1));
        }
        
        return maxScore;
    }
}