 class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Create a frequency map for arr1
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // List to hold the sorted result
        List<Integer> result = new ArrayList<>();

        // Add elements from arr2 in order
        for (int num : arr2) {
            int count = freqMap.get(num);
            for (int i = 0; i < count; i++) {
                result.add(num);
            }
            freqMap.remove(num);
        }

        // Add the remaining elements in ascending order
        List<Integer> remaining = new ArrayList<>();
        for (int num : freqMap.keySet()) {
            int count = freqMap.get(num);
            for (int i = 0; i < count; i++) {
                remaining.add(num);
            }
        }
        Collections.sort(remaining);
        result.addAll(remaining);

        // Convert the result list to an array
        int[] sortedArr = new int[arr1.length];
        for (int i = 0; i < result.size(); i++) {
            sortedArr[i] = result.get(i);
        }

        return sortedArr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] arr1_1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2_1 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(solution.relativeSortArray(arr1_1, arr2_1))); // Output: [2,2,2,1,4,3,3,9,6,7,19]

        // Test case 2
        int[] arr1_2 = {28,6,22,8,44,17};
        int[] arr2_2 = {22,28,8,6};
        System.out.println(Arrays.toString(solution.relativeSortArray(arr1_2, arr2_2))); // Output: [22,28,8,6,17,44]
    }
}
