class Solution {
    public int minIncrementForUnique(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        
        int moves = 0;
        // Start with the first element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is not greater than the previous element
            if (nums[i] <= nums[i - 1]) {
                // Calculate the needed increment to make nums[i] unique
                int increment = nums[i - 1] + 1 - nums[i];
                // Increment moves by the required amount
                moves += increment;
                // Update the current element to its new unique value
                nums[i] = nums[i - 1] + 1;
            }
        }
        
        return moves;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[] nums1 = {1, 2, 2};
        int[] nums2 = {3, 2, 1, 2, 1, 7};

        System.out.println(sol.minIncrementForUnique(nums1)); // Output: 1
        System.out.println(sol.minIncrementForUnique(nums2)); // Output: 6
    }
}
