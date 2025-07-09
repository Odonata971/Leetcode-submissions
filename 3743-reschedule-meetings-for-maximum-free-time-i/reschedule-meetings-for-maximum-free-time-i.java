class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] breaks = new int[n + 1];

        // Initial gap before the first event
        breaks[0] = startTime[0];

        // Get all gaps
        for (int i = 1; i < n; i++) {
            breaks[i] = startTime[i] - endTime[i - 1];
        }
        breaks[n] = eventTime - endTime[n - 1]; // Remaining time between last event and end of the day

        // Compute first possible k sum of time breaks
        int windowSum = 0;
        for (int i = 0; i <= k && i < breaks.length; i++) {
            windowSum += breaks[i];
        }

        // Use the sliding window to compare all possible breaks sums
        int maxFreeTime = windowSum;
        for (int i = k + 1; i < breaks.length; i++) {
            windowSum += breaks[i] - breaks[i - k - 1];
            maxFreeTime = Math.max(maxFreeTime, windowSum);
        }
        return maxFreeTime;
    }
}