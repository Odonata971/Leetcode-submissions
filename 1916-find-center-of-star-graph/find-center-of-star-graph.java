class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] counts = new int[100001];

        for (int i = 0; i < n; i++) {
            counts[edges[i][0]]++;
            counts[edges[i][1]]++;
        }

        int res = 0;
        for (int i = 0; i < counts.length; i++) {
            res = counts[i] > res ? i : res;
        }
        return res;

    }
}