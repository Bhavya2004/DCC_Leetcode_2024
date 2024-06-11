class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Create a map to store the frequency of elements in arr1
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Create a list to store the sorted elements
        List<Integer> sortedList = new ArrayList<>();
        
        // Add the elements from arr2 in the order specified
        for (int num : arr2) {
            int frequency = frequencyMap.getOrDefault(num, 0);
            for (int i = 0; i < frequency; i++) {
                sortedList.add(num);
            }
            frequencyMap.remove(num);
        }
        
        // Add the remaining elements from arr1 in ascending order
        List<Integer> remainingList = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(remainingList);
        for (int num : remainingList) {
            int frequency = frequencyMap.get(num);
            for (int i = 0; i < frequency; i++) {
                sortedList.add(num);
            }
        }
        
        // Convert the list to an array
        int[] sortedArray = new int[sortedList.size()];
        for (int i = 0; i < sortedList.size(); i++) {
            sortedArray[i] = sortedList.get(i);
        }
        
        return sortedArray;
    }
}