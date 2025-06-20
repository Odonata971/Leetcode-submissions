class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;

        if (n < 3) return 0;
        int ans = 0;
        
        Set<Integer> arr = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr.add(nums[i]);
        }
        for (int j = 1; j < n - 1; j++) {
            if (arr.contains(nums[j] + diff) && arr.contains(nums[j] - diff)) ans++;
        }
        return ans;
    }
}