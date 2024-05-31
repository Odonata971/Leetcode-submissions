class Solution {
    public int[] singleNumber(int[] nums) {
        int finalXor = 0;

        for (int num : nums) {
            finalXor ^= num;
        }

        int group0 = 0;
        int group1 = 0;

        int bitPosDif = 0;

        while (((finalXor >> bitPosDif) & 1) != 1) {
            bitPosDif++;
        }

        for (int num: nums) {
            if (((num >> bitPosDif) & 1) == 1) {
                group1 ^= num;
            } else {
                group0 ^= num;
            }
        }
        return new int[]{group0, group1};
        
    }
}