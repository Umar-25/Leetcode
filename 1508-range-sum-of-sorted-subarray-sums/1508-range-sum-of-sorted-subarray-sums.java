

class Solution {
    private static final int MOD = 1_000_000_007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        int L = Arrays.stream(nums).min().getAsInt();
        int R = Arrays.stream(nums).sum();

        return (int) ((firstKSubarraysSum(nums, n, right, L, R) - firstKSubarraysSum(nums, n, left - 1, L, R) + MOD) % MOD);
    }

    private long[] subarraysAndSumNoGreaterThan(int[] nums, int n, int m) {
        int count = 0;   // the number of subarrays <= m
        long total = 0;  // sum(subarrays)
        int sum = 0;     // the current sum
        int window = 0;  // the window sum

        for (int i = 0, j = 0; j < n; ++j) {
            sum += nums[j] * (j - i + 1);
            window += nums[j];  // Extend each subarray that ends in j.
            while (window > m) {
                sum -= window;
                window -= nums[i++];  // Shrink the window.
            }
            count += j - i + 1;
            total += sum;
        }

        return new long[]{count, total};
    }

    private long firstKSubarraysSum(int[] nums, int n, int k, int L, int R) {
        int l = L;
        int r = R;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (subarraysAndSumNoGreaterThan(nums, n, m)[0] < k)
                l = m + 1;
            else
                r = m;
        }

        long[] result = subarraysAndSumNoGreaterThan(nums, n, l);
        int count = (int) result[0];
        long total = result[1];
        // If count != k, there're subarray(s) have the same sum as l.
        return total - l * (count - k);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 3, 4};
        int left1 = 1, right1 = 5;
        System.out.println(sol.rangeSum(nums1, nums1.length, left1, right1)); // Output example

        int[] nums2 = {1, 2, 3, 4};
        int left2 = 3, right2 = 4;
        System.out.println(sol.rangeSum(nums2, nums2.length, left2, right2)); // Output example
    }
}
