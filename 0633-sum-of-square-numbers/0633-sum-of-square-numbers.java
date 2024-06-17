class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int c1 = 5;
        System.out.println(solution.judgeSquareSum(c1)); // Output: true

        // Test case 2
        int c2 = 3;
        System.out.println(solution.judgeSquareSum(c2)); // Output: false

        // Additional test case
        int c3 = 4;
        System.out.println(solution.judgeSquareSum(c3)); // Output: true
    }
}
