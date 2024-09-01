class Solution {
    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
        if (m * n != original.size) return emptyArray()

        val res = Array(m) {IntArray(n)}
        var count = 0;

        for (i in 0..m - 1) {
            for (j in 0..n - 1) {
                res[i][j] = original[count++]
            }
        }
        return res
    }
}