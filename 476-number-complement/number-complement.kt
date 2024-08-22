class Solution {
    fun findComplement(num: Int): Int {
        val bits = Integer.toBinaryString(num).length
        val maxBound = (2.0.pow(bits) - 1).toInt()
        return num xor maxBound
    }
    
}