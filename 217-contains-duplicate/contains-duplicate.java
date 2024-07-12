class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!uniqueNums.add(nums[i])) return true;
        }
        return nums.length != uniqueNums.size();
    }
}