class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        // [-4, -1, -1, 0, 1, 2]
        
        // Step 2: Fix one element using loop
        for (int i = 0; i < nums.length - 2; i++) {
            
            // Skip duplicate fixed elements
            // agar pehle wala same tha, same triplets aayenge
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Step 3: Two pointers for remaining array
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found a triplet!
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates on left side
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates on right side
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    // Move both pointers inward
                    left++;
                    right--;
                    
                } else if (sum < 0) {
                    left++;  // need bigger sum
                } else {
                    right--; // need smaller sum
                }
            }
        }
        
        return result;
    }
}