class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    // Swap nums[low] and nums[mid]
                    int temp0 = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp0;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    // Swap nums[mid] and nums[high]
                    int temp2 = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp2;
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {2, 0, 2, 1, 1, 0};
        sol.sortColors(nums1);
        System.out.println("Sorted colors: " + java.util.Arrays.toString(nums1)); // Output: [0, 0, 1, 1, 2, 2]

        int[] nums2 = {2, 0, 1};
        sol.sortColors(nums2);
        System.out.println("Sorted colors: " + java.util.Arrays.toString(nums2)); // Output: [0, 1, 2]
    }
}
