class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] result = new int[n / 3][3];

        for (int i = 0; i < n; i += 3) {
            //Get all array elts to check their max difference
            int i1 = nums[i], i2 = nums[i + 1], i3 = nums[i + 2];
            if (i3 - i1 > k) {  // make max - min difference
                return new int[0][0];
            }
            result[i / 3][0] = i1;
            result[i / 3][1] = i2;
            result[i / 3][2] = i3;
        }
        return result;
    }
}