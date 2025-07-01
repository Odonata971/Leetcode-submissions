class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 0;
        long middle = 0;
        long right = 46341; //cause sqrt(Integer.MAX_VALUE == 46341)

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