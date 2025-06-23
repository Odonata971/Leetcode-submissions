class Solution {
     public int minOperations(List<Integer> nums, int k) {
        long mask = 0;
        // If k = 2, make the mask as (0000 0100) - 1 -> (0000 0011) 
        long wantedMask = (1L << k) - 1; 
        int answer  = 0;
        int idx = nums.size() - 1;

        while (mask != wantedMask) {
            if (idx < 0) {
                return -1; 
            }
            answer++;

            // Gets the last element in the list by removing it
            int lastElement = nums.remove(idx);
            if (lastElement <= k) {
                // Make an OR operation on the lastElement corresponding bit on the mask to mark it as flagged and viewed
                mask |= (1L << (lastElement - 1));
            }
            idx--;
        }
        return answer;
    }
}