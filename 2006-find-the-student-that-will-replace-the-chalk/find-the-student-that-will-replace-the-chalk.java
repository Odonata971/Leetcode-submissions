class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += chalk[i];
        }

        int left = (int) (k % sum);
        for (int i = 0; i < n; i++) {
            if (left < chalk[i]) return i;
            left -= chalk[i];
        }
        return 0;
    }
}