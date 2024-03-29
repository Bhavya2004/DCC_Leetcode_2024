class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = -1;
        for(int i : nums) max = Math.max(max,i);
        long ans =0;
        int l = 0;
        int c = 0;
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]==max) c++;

            while(c>=k)
            {
                
                if(nums[l]==max)c--;
                l++;
                
            }
            ans+=l;
        }

        return ans;
    }
}