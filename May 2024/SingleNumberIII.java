public class SingleNumberIII {
    public int[] findSingleNumbers(int[] nums) {
        // Step 1: Get the XOR of the two unique numbers
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        // Step 2: Find the rightmost set bit in the XOR result
        int rightmostSetBit = xor & (-xor);
        
        // Step 3: Divide the numbers into two groups based on the rightmost set bit
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        
        return result;
    }
}