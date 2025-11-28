class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i] > 0 ? nums[i] : -nums[i];
          
            if (nums[currNum - 1] > 0) {
                nums[currNum - 1] = -nums[currNum - 1];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}