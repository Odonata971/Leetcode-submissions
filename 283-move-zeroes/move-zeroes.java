class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int lastZero = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < lastZero; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                lastZero--;
            }
        }
    }
}