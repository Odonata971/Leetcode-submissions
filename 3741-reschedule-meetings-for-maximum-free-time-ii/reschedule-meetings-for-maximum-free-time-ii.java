
class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        
        // Original gaps
        List<int[]> gaps = new ArrayList<>();
        
        // gap before first meeting
        if (startTime[0] > 0) {
            gaps.add(new int[]{0, startTime[0]});
        }
        
        // gaps between meetings
        for (int i = 1; i < n; i++) {
            if (startTime[i] > endTime[i - 1]) {
                gaps.add(new int[]{endTime[i - 1], startTime[i]});
            }
        }
        
        // gap after last meeting
        if (eventTime > endTime[n - 1]) {
            gaps.add(new int[]{endTime[n - 1], eventTime});
        }
        
        // Sort gaps by size descending to optimize search (early termination)
        gaps.sort((a, b) -> Integer.compare(b[1] - b[0], a[1] - a[0]));
        
        // Get max original gap
        int maxGap = gaps.isEmpty() ? 0 : gaps.get(0)[1] - gaps.get(0)[0];
        
        // Try rescheduling each meeting
        for (int i = 0; i < n; i++) {
            int dur = endTime[i] - startTime[i];
            
            // Remove current meeting and create merged gap
            int left = (i == 0) ? 0 : endTime[i - 1];
            int right = (i == n - 1) ? eventTime : startTime[i + 1];
            int mergedGap = right - left;
            
            // Case 1: Place meeting back in the merged gap itself
            if (mergedGap >= dur) {
                maxGap = Math.max(maxGap, mergedGap - dur);
            }
            
            // Case 2: Try placing this meeting in any other gap
            // Optimization: early termination since gaps are sorted by size
            for (int[] gap : gaps) {
                int gapLen = gap[1] - gap[0];
                
                // If this gap is too small, all following gaps will be too small
                if (gapLen < dur) {
                    break;
                }
                
                // Check if this gap overlaps with the merged gap
                boolean overlapsMerged = !(gap[1] <= left || gap[0] >= right);
                
                if (!overlapsMerged) {
                    // Independent gap - we can place the meeting here
                    maxGap = Math.max(maxGap, mergedGap);
                    break; // Found optimal solution for this meeting
                }
            }
        }
        
        return maxGap;
    }
}