class Solution {
    fun missingNumber(nums: IntArray): Int {
        val n : Int = nums.size;
        val expectedSum : Int = n * (n + 1) / 2;
        var numSum : Int = 0;
        for (num : Int in nums) {
            numSum += num;
        }
        return expectedSum - numSum;
    }
}