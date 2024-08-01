class Solution {
    fun countSeniors(details: Array<String>): Int {
        var oldPassengers : Int = 0

        for (s in details) {
            if (s.substring(11, 13).toInt() > 60) oldPassengers++
        }
        return oldPassengers
    }
}