class Solution {
    fun findMinDifference(timePoints: List<String>): Int {
        val n: Int = timePoints.size
        var times: IntArray = IntArray(n)
        var minDiff: Int = Int.MAX_VALUE
        val MINUTES_IN_A_DAY: Int = 1440

        for (i in 0 until n) {
            times[i] = getMinutes(timePoints[i])
        }

        times.sort()
        
        for (i in 1 until n) {
            minDiff = minOf(minDiff, abs(times[i] - times[i - 1]))
        }
        return minOf(minDiff, abs(times[0] + MINUTES_IN_A_DAY - times[n - 1]))
    }

    fun getMinutes(time: String): Int {
        val hours: Int = time.substring(0,2).toInt()
        val minutes: Int = time.substring(3,5).toInt()
        return hours * 60 + minutes
    }
}