class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1); // To account for subarrays that sum to a multiple of k directly
        int count = 0, prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;
            int remainder = prefixSum % k;
            if (remainder < 0) remainder += k; // To handle negative remainders

            if (remainderCount.containsKey(remainder)) {
                count += remainderCount.get(remainder);
            }

            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {4, 5, 0, -2, -3, 1};
        int k1 = 5;
        System.out.println("Number of subarrays divisible by " + k1 + " is: " + sol.subarraysDivByK(nums1, k1)); // Output: 7

        int[] nums2 = {5};
        int k2 = 9;
        System.out.println("Number of subarrays divisible by " + k2 + " is: " + sol.subarraysDivByK(nums2, k2)); // Output: 0
    }
}