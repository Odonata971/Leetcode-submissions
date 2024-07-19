class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (minLine(matrix[i][j], matrix[i]) && maxCol(matrix[i][j], matrix, j)) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }
        return luckyNumbers;
    }

    private boolean minLine(int value, int[] line) {
        int min = line[0];
        for (int i = 0; i < line.length; i++) {
            if (min > line[i]) {
                min = line[i];
            }
        }
        return min == value;
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