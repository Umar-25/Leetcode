 class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        
        // Create a job list with difficulty and profit
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
        // Sort jobs by difficulty
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        // Sort workers by their ability
        Arrays.sort(worker);
        
        int maxProfit = 0, i = 0, bestProfit = 0;
        
        // Iterate through each worker
        for (int ability : worker) {
            // Find the best job the worker can do
            while (i < n && ability >= jobs[i][0]) {
                bestProfit = Math.max(bestProfit, jobs[i][1]);
                i++;
            }
            maxProfit += bestProfit;
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] difficulty1 = {2, 4, 6, 8, 10};
        int[] profit1 = {10, 20, 30, 40, 50};
        int[] worker1 = {4, 5, 6, 7};
        System.out.println(solution.maxProfitAssignment(difficulty1, profit1, worker1)); // Output: 100

        // Test case 2
        int[] difficulty2 = {85, 47, 57};
        int[] profit2 = {24, 66, 99};
        int[] worker2 = {40, 25, 25};
        System.out.println(solution.maxProfitAssignment(difficulty2, profit2, worker2)); // Output: 0
    }
}
