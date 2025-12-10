class Solution {
    public int specialTriplets(int[] nums) {
        final long MOD = 1_000_000_007;
        
        int[] prevFreq = new int[200001];
        int[] nextFreq = new int[200001];
        long result = 0;

        // Count frequencies after index 0 cause i & k have to be the same number 
        // so they appear twice in the array
        for (int i = 0; i < nums.length; i++) {
            nextFreq[nums[i]]++;
        }
        
        for (int num : nums) {
            nextFreq[num]--;
            int iFreq = prevFreq[num * 2];
            int kFreq = nextFreq[num * 2];
            result = (result + (long) iFreq * kFreq) % MOD;
            prevFreq[num]++;
        }
        return (int) result;
    }
}