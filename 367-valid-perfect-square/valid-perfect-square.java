class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long left = 0;
        long middle = 0;
        long right = num / 2;

        while (left <= right) {
            middle = (left + right) / 2;
            long squared = middle * middle;
            if (squared == num) {
                return true;
            } else if (squared > num) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }
}