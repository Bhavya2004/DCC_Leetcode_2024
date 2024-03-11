class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        // Append characters from order in the order specified
        for (char c : order.toCharArray()) {
            if (freqMap.containsKey(c)) {
                int count = freqMap.get(c);
                while (count > 0) {
                    sb.append(c);
                    count--;
                }
                freqMap.remove(c);
            }
        }
        
        // Append remaining characters from s
        for (char c : freqMap.keySet()) {
            int count = freqMap.get(c);
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }
        
        return sb.toString();
    }
}