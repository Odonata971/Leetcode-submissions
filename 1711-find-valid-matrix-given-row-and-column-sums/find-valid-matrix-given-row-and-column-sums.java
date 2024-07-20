class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int sumCols = sumCols(matrix, j, colSum[j]);
                if (rowSum[i] + sumCols <= colSum[j]) {
                    matrix[i][j] = rowSum[i];
                    break;

                } else if (rowSum[i] + sumCols > colSum[j] && sumCols < colSum[j]){
                    matrix[i][j] = colSum[j] - sumCols;
                    rowSum[i] -= colSum[j] - sumCols;

                } else {
                    continue;
                }
            }
        }
        return matrix;
    }

    private static int sumCols(int[][] matrix, int j, int maxValue) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            result += matrix[i][j];
        }
        return result;
    }
}