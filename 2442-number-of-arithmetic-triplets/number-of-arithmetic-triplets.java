class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;

        if (n < 3) return 0;
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) ans++;
                }
            }
        }
        return ans;
    }
}