class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) return false;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            count = (arr[i] & 1) == 1 ? count + 1 : 0;
            if (count == 3) return true;
        }
        return false;
    }
}