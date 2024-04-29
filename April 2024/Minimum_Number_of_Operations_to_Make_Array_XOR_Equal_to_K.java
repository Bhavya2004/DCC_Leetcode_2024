class Solution {
    public int minOperations(int[] nums, int k) {
        // Calculate the XOR of all elements in the array
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        // If the XOR is already equal to k, no operations are needed
        if (xor == k) {
            return 0;
        }
        
        // Calculate the XOR of XOR and k
        int diff = xor ^ k;
        
        // Count the number of set bits in the XOR of XOR and k
        int count = 0;
        while (diff > 0) {
            if ((diff & 1) == 1) {
                count++;
            }
            diff >>= 1;
        }
        
        return count;
    }
}