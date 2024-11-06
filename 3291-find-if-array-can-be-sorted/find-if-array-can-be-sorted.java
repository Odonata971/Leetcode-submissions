class Solution {
    public boolean canSortArray(int[] nums) {
        short previousMax = 0;
        short currentMin = 0;
        short currentMax = 0;

        byte previousBitCount = 0;
        for (int num : nums) {
            byte currentBitCount = (byte)Integer.bitCount(num);
            if (previousBitCount == currentBitCount) {
                currentMin = currentMin > num ? (short)num : currentMin;
                currentMax = currentMax < num ? (short)num : currentMax;
            } else if (currentMin < previousMax) {
                return false;
            } else {
                previousMax = currentMax;
                currentMin = currentMax = (short)num;
                previousBitCount = currentBitCount;
            }
        }
        return currentMin >= previousMax;
    }
}