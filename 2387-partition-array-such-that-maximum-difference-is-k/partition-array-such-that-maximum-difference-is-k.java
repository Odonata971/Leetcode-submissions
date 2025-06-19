class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int lastNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(lastNumber - nums[i]) > k) {
                ans++;
                lastNumber = nums[i];
            }
        }
        return ans + 1;
    }
}