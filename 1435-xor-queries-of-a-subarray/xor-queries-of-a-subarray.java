class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // Optimized version
        int n = queries.length;
        int[] xorResults = new int[n];

        int[] xorCalc = new int[arr.length];
        xorCalc[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            xorCalc[i] = xorCalc[i - 1] ^ arr[i];
        }

        for (int i = 0; i < n; i++) {
            int deb = queries[i][0];
            int end = queries[i][1];

            xorResults[i] = deb == 0 ? xorCalc[end] : xorCalc[end] ^ xorCalc[deb - 1];
        }
        return xorResults;
    }
}