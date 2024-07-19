class Solution {
    /* Next approach trying to optimize time */
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int column = minLine(matrix, i);

            if (maxCol(matrix, i, column)) {
                luckyNumbers.add(matrix[i][column]);
            }
        }
        return luckyNumbers;
    }

    private int minLine(int[][] matrix, int i) {
        int min = matrix[i][0];
        int col = 0;
        for (int j = 1; j < matrix[i].length; j++) {
            if (min >  matrix[i][j]) {
                min =  matrix[i][j];
                col = j;
            }
        }
        return col;
    }

    private boolean maxCol(int[][] matrix,int i, int j) {
        int max = matrix[i][j];
        for (int k = 0; k < matrix.length; k++) {
            if (max < matrix[k][j]) {
                return false;
            }
        }
        return true;
    }
}