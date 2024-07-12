class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        var hashMap: HashMap<Int, Int> = HashMap<Int, Int>()

        for (i in 0..nums.size -1) {
            if (hashMap.containsKey(nums[i])) {
                if (i - hashMap.get(nums[i])!! <= k) {
                    return true;
                }
            }
            hashMap.put(nums[i], i)
        }
        return false;
    }
}