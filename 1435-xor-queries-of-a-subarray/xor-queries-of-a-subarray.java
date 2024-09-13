class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] xorResults = new int[n];

        for (int i = 0; i < n; i++) {
            xorResults[i] = computeXors(arr, queries[i]);
        }
        return xorResults;
    }

    private int computeXors(int[] arr, int[] query) {
        int xor = arr[query[0]];
        for (int i = query[0] + 1; i <= query[1]; i++) {
            xor ^= arr[i];
        }
        return xor;
    }
}