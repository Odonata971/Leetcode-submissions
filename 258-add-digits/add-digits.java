class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            int numCopy = num;
            int inter = 0;
            while (numCopy != 0) {
                inter += numCopy%10;
                numCopy /= 10;
            }
            num = inter;
        }
        return num;
    }
}