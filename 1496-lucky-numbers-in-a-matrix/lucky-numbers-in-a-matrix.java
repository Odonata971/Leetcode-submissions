class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (checkLucky(matrix[i][j], matrix, i, j)) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }
        return luckyNumbers;
    }

    private boolean checkLucky(int value, int[][] matrix, int i, int j) {
        int min = matrix[i][0];
        for (int k = 0; k < matrix[i].length; k++) {
            if (min > matrix[i][k]) {
                min = matrix[i][k];
            }
        }

        int max = matrix[0][j];
        for (int k = 0; k < matrix.length; k++) {
            if (max < matrix[k][j]) {
                max = matrix[k][j];
            }
        }
        return min == value && max == value;
    }

    private boolean maxCol(int value, int[][] matrix, int j) {
        int max = matrix[0][j];
        for (int i = 0; i < matrix.length; i++) {
            if (max < matrix[i][j]) {
                max = matrix[i][j];
            }
        }
        return max == value;
    }
}