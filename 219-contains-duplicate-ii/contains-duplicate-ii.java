class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> appearances = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (appearances.containsKey(nums[i])) {
                if ((i - appearances.get(nums[i]) <= k)) {
                    return true;
                }
            }
            appearances.put(nums[i], i);
        }
        return false;
    }
}