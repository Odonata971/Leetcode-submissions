class Solution {
    fun minSteps(n: Int): Int {
        if (n == 1) return 0

        var steps : Int = 0
        var factor : Int = 2
        var nV : Int = n

        while (nV > 1) {
            while (nV % factor == 0) {
                steps += factor
                nV /= factor
            }
            factor++
        }
        return steps
    }
}