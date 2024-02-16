class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> sortedNums = new ArrayList<>(frequencyMap.keySet());
        sortedNums.sort((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));
        
        int count = sortedNums.size();
        for (int num : sortedNums) {
            int frequency = frequencyMap.get(num);
            if (k >= frequency) {
                k -= frequency;
                count--;
            } else {
                break;
            }
        }
        
        return count;
    }
}