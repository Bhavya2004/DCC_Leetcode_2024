class Solution {
    public int findMaxK(int[] nums) {
         int largestPositiveInteger = -1;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(-num)) {
                largestPositiveInteger = Math.max(largestPositiveInteger, Math.abs(num));
            }
            set.add(num);
        }

        return largestPositiveInteger;
    }
}