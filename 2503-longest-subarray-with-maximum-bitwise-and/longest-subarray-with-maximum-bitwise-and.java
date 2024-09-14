class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = nums[0];
        int maxLen = 1;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal,nums[i]);
        }
        int localMax = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == maxVal) {
                localMax++;
            } else {
                maxLen = localMax > maxLen ? localMax : maxLen;
                localMax = 0;
            }
            maxLen = localMax > maxLen ? localMax : maxLen;
        }
        return maxLen;
    }
}