class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];

        // Combine profits and capital into a single array for easy sorting
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        // Sort projects by their capital requirement
        Arrays.sort(projects, (a, b) -> a[0] - b[0]);

        // Max heap to store the profits of projects that can be started
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int index = 0;

        // Iterate up to k times
        for (int i = 0; i < k; i++) {
            // Push all projects that can be started with the current capital into the max heap
            while (index < n && projects[index][0] <= w) {
                maxHeap.offer(projects[index][1]);
                index++;
            }

            // If we can't start any project, break out of the loop
            if (maxHeap.isEmpty()) {
                break;
            }

            // Pop the project with the maximum profit
            w += maxHeap.poll();
        }

        return w;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k1 = 2, w1 = 0;
        int[] profits1 = {1, 2, 3};
        int[] capital1 = {0, 1, 1};
        System.out.println(solution.findMaximizedCapital(k1, w1, profits1, capital1)); // Output: 4

        int k2 = 3, w2 = 0;
        int[] profits2 = {1, 2, 3};
        int[] capital2 = {0, 1, 2};
        System.out.println(solution.findMaximizedCapital(k2, w2, profits2, capital2)); // Output: 6
    }
}