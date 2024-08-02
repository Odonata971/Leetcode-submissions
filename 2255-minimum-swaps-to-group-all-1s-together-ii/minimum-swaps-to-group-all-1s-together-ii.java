class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int count = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            k += nums[i];
        }
        for (int i = 0; i < k; i++) {
            count += nums[i];
        }
        int max = count;
        for (int i = k; i < n + k; i++) {
            count += nums[i % n] - nums[(i - k + n) % n];
            max = Math.max(max, count);
        }
        return k - max;
    }
}