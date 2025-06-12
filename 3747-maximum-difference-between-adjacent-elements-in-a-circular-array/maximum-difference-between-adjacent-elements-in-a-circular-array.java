class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxDistance = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            maxDistance = Math.max(Math.abs(nums[i - 1] - nums[i]), maxDistance);
        }
        return Math.max(Math.abs(nums[0] - nums[n - 1]), maxDistance);  
    }
}