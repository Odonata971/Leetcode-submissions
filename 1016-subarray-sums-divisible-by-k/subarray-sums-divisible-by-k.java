class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] remainderFreq = new int[k];
        remainderFreq[0] = 1; // Initialize with prefix sum 0 having frequency 1
        int sum = 0;
        int count = 0;
        
        for (int num : nums) {
            sum = (sum + num) % k;
            if (sum < 0) // Ensure the remainder is non-negative
                sum += k;
            count += remainderFreq[sum];
            remainderFreq[sum]++;
        }
        
        return count;
    }
}