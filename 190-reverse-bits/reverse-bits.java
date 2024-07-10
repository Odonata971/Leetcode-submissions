public class Solution {
    // you need treat n as an unsigned value
    private static final int INTEGER_SIZE = 32;
    
    public int reverseBits(int n) {
        int reversedNumber = 0;
        
        for (int bitPosition = 0; bitPosition < INTEGER_SIZE; bitPosition++) {
            reversedNumber <<= 1;
            reversedNumber = reversedNumber | (n & 1);
            //to shift with unsigned value explicitely, if >>, shifts with signed values so it is not explicit
            n = n >>> 1;
        }
        
        return reversedNumber;
    }
}