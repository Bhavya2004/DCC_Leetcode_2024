// Approach 1: Bruete Force (Timit Limit Exceed)
// class Solution {
//     public int findDuplicate(int[] nums) {
//         int n = nums.length;
        
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (nums[i] == nums[j]) {
//                     return nums[i];
//                 }
//             }
//         }
        
//         // If no duplicate is found, return -1 or any other appropriate value
//         return -1;
//     }
// }

//Approach 2 : HashSet
class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        
        // If no duplicate is found, return -1 or any other appropriate value
        return -1;
    }
}
