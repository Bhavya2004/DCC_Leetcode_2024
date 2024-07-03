class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int n = nums.length;
        int minDifference = Integer.MAX_VALUE;
        
        // Try removing the largest 3 elements
        minDifference = Math.min(minDifference, nums[n - 4] - nums[0]);
        
        // Try removing the smallest 3 elements
        minDifference = Math.min(minDifference, nums[n - 1] - nums[3]);
        
        // Try removing the largest 2 elements and the smallest element
        minDifference = Math.min(minDifference, nums[n - 3] - nums[1]);
        
        // Try removing the largest element and the smallest 2 elements
        minDifference = Math.min(minDifference, nums[n - 2] - nums[2]);
        
        return minDifference;
    }
}