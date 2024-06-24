class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flips = new int[n];
        int flipCount = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            flipCount ^= flips[i];
            if (nums[i] == flipCount) {
                if (i + k > n) {
                    return -1;
                }
                result++;
                flipCount ^= 1;
                if (i + k < n) {
                    flips[i + k] ^= 1;
                }
            }
        }

        return result;
        
    }
}