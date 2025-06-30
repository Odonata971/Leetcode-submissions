class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Get all numbers frequency in the list
        for (int i = 0; i < nums.length ; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        int lHS = 0;

        //Iterate over freq map to get longest Harmonious Subsequence
        for (Integer key : freq.keySet()) {
            if (freq.containsKey(key + 1)) {
                lHS = Math.max(freq.get(key) + freq.get(key + 1), lHS);
            }
        }
        return lHS;
    }
}