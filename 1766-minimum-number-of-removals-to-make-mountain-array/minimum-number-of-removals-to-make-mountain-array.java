class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // Step 1: Calculate the LIS for each index
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Step 2: Calculate the LDS for each index
        int[] lds = new int[n];
        Arrays.fill(lds, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Step 3: Find the longest mountain array possible
        int longestMountain = 0;
        for (int i = 1; i < n - 1; i++) {
            // A peak is valid if LIS[i] > 1 and LDS[i] > 1
            if (lis[i] > 1 && lds[i] > 1) {
                longestMountain = Math.max(longestMountain, lis[i] + lds[i] - 1);
            }
        }

        // Step 4: Calculate the minimum removals
        return n - longestMountain;
    }
}