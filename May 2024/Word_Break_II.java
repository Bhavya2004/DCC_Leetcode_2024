class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, new HashSet<>(wordDict), new HashMap<>());
    }
    public List<String> wordBreakHelper(String s, Set<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        List<String> result = new ArrayList<>();
        
        if (wordDict.contains(s)) {
            result.add(s);
        }
        
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordDict.contains(prefix)) {
                String suffix = s.substring(i);
                List<String> suffixResult = wordBreakHelper(suffix, wordDict, memo);
                for (String word : suffixResult) {
                    result.add(prefix + " " + word);
                }
            }
        }
        
        memo.put(s, result);
        return result;
    }
}