class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> occurrences = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            occurrences.put(nums[i], occurrences.getOrDefault(nums[i], 0) + 1);
            if (occurrences.get(nums[i]) == 2){
                return true;
            }
        }
        return false;
    }
}