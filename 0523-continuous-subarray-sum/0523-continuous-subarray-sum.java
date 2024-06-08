class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // HashMap to store the remainder of prefix sum and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initializing with remainder 0 at index -1 to handle edge cases
        map.put(0, -1);
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            // Adjusting the remainder to be positive
            if (remainder < 0) {
                remainder += k;
            }
            // If the remainder is already in the map, check the subarray length
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) > 1) {
                    return true;
                }
            } else {
                // Store the index of the first occurrence of this remainder
                map.put(remainder, i);
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println(sol.checkSubarraySum(nums1, k1)); // Output: true

        // Test case 2
        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;
        System.out.println(sol.checkSubarraySum(nums2, k2)); // Output: true

        // Test case 3
        int[] nums3 = {23, 2, 6, 4, 7};
        int k3 = 13;
        System.out.println(sol.checkSubarraySum(nums3, k3)); // Output: false
        
    }
}