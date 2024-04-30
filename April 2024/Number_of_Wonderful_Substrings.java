class Solution {
    public long wonderfulSubstrings(String word) {
        Map<Integer, Long> count = new HashMap<>();
        count.put(0, 1L);
        long result = 0;
        int prefix = 0;
        
        for (char c : word.toCharArray()) {
            prefix ^= 1 << (c - 'a');
            result += count.getOrDefault(prefix, 0L);
            
            for (int i = 0; i < 10; i++) {
                int mask = prefix ^ (1 << i);
                result += count.getOrDefault(mask, 0L);
            }
            
            count.put(prefix, count.getOrDefault(prefix, 0L) + 1);
        }
        
        return result;
    }
}