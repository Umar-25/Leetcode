 class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long miss = 1; // Smallest number that cannot be formed
        int i = 0; // Index for nums array
        
        while (miss <= n) {
            // If the current number in nums can be used to form `miss`
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                // Patch the array with `miss`
                miss += miss;
                patches++;
            }
        }
        
        return patches;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 3};
        int n1 = 6;
        System.out.println(solution.minPatches(nums1, n1)); // Output: 1

        // Test case 2
        int[] nums2 = {1, 5, 10};
        int n2 = 20;
        System.out.println(solution.minPatches(nums2, n2)); // Output: 2

        // Test case 3
        int[] nums3 = {1, 2, 2};
        int n3 = 5;
        System.out.println(solution.minPatches(nums3, n3)); // Output: 0
    }
}
