 class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {2, 2, 1};
        System.out.println(solution.singleNumber(nums1));  // Expected Output: 1

        // Example 2
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(solution.singleNumber(nums2));  // Expected Output: 4

        // Example 3
        int[] nums3 = {1};
        System.out.println(solution.singleNumber(nums3));  // Expected Output: 1
    }
}