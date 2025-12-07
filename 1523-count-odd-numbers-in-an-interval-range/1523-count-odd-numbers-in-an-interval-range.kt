class Solution {
    fun countOdds(low: Int, high: Int): Int {
        return (high - low) / 2 + (if (low % 2 == 0 && high % 2 == 0) 0 else 1);
    }
}