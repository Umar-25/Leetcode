class Solution {
    public int heightChecker(int[] heights) {
        // Create a copy of the heights array and sort it to get the expected order
        int[] expected = heights.clone();
        Arrays.sort(expected);

        // Count the number of indices where heights[i] != expected[i]
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] heights1 = {1, 1, 4, 2, 1, 3};
        System.out.println("Number of indices that do not match: " + sol.heightChecker(heights1)); // Output: 3

        int[] heights2 = {5, 1, 2, 3, 4};
        System.out.println("Number of indices that do not match: " + sol.heightChecker(heights2)); // Output: 5

        int[] heights3 = {1, 2, 3, 4, 5};
        System.out.println("Number of indices that do not match: " + sol.heightChecker(heights3)); // Output: 0
    }
}
        
    
