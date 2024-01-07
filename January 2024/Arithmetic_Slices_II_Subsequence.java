class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer>[] dp = new Map[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                int d = (int) diff;
                int sum = dp[j].getOrDefault(d, 0);
                int original = dp[i].getOrDefault(d, 0);
                dp[i].put(d, original + sum + 1);
                count += sum;
            }
        }

        return count;
    }
}