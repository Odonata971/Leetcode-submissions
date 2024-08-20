class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 1][n + 1];
        int[] suffixSum = new int[n + 1];

        //suffix sum
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        //fill the dynamic programming table
        //first iterate over each pile in the array from the end to the start
        for (int i = n - 1; i >= 0; i--) {
            //then iterate over each of the possible M from 1 to n
            for (int M = 1; M <= n; M++) {
                //finally iterate over each possibility x of the interval between 1 to 2*M
                //of course X cannot be more than n 
                for (int X = 1; X <= 2 * M && i + X <= n; X++) {
                    //this formula take the maximum between the value already there and 
                    //the difference between what she can get (suffixSum[i]) and what bob can have next turn (dp[i + X][max(M, X)])
                    dp[i][M] = Math.max(dp[i][M], suffixSum[i] - dp[i + X][Math.max(M, X)]);
                }
            }
        }
        return dp[0][1];
    }
}