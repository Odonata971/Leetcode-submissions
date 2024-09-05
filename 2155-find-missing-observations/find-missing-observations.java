class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sumM = 0;

        for (int num : rolls) {
            sumM += num;
        }

        int totalSum = mean * (rolls.length + n);
        int missing = totalSum - sumM;

        int baseValue = missing / n;
        int left = missing % n;

        if (baseValue <= 0 || baseValue > 6 || (baseValue == 6 && left > 0)) {
            return new int[0];
        }

        int[] ans = new int[n];
        Arrays.fill(ans, baseValue);

        for (int i = 0; i < left; i++) {
            ans[i]++;
        }
        return ans;
    }
}