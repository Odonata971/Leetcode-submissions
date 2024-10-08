class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for (int num = 0; num < arr.length; num++) {
            int rem = arr[num] % k;
            if (rem < 0) {
                rem = rem + k;
            }
            freq[rem]++;
        }
        if (freq[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (freq[i] != freq[k - i]) {
                return false;
            }
        }
        return true;
    }
}