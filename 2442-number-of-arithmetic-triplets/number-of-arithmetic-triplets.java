class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;

        if (n < 3) return 0;
        int ans = 0;
        
        HashMap<Integer, Integer> arr = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr.put(nums[i], i);
        }
        for (int j = 1; j < n - 1; j++) {
            if (arr.containsKey(nums[j] + diff) && arr.containsKey(nums[j] - diff)) ans++;
        }
        return ans;
    }
}