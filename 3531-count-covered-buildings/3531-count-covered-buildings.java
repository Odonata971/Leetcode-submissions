class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        int maxCol = 0;
        int maxRow = 0;
        for (int i = 0; i < buildings.length; i++) {
            maxRow = (buildings[i][0] > maxRow) ? buildings[i][0] : maxRow;
            maxCol = (buildings[i][1] > maxCol) ? buildings[i][1] : maxCol; 
        }

        // For each column, track the min and max row that has a building
        int[] minRowInCol = new int[maxCol + 1];
        int[] maxRowInCol = new int[maxCol + 1];
        
        // For each row, track the min and max column that has a building
        int[] minColInRow = new int[maxRow + 1];
        int[] maxColInRow = new int[maxRow + 1];

        for (int i = 0; i <= maxCol; i++) {
            minRowInCol[i] = Integer.MAX_VALUE;
            maxRowInCol[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i <= maxRow; i++) {
            minColInRow[i] = Integer.MAX_VALUE;
            maxColInRow[i] = Integer.MIN_VALUE;
        }

        // Populate the arrays with min/max values
        for (int i = 0; i < buildings.length; i++) {
            int row = buildings[i][0];
            int col = buildings[i][1];

            minRowInCol[col] = Math.min(minRowInCol[col], row);
            maxRowInCol[col] = Math.max(maxRowInCol[col], row);

            minColInRow[row] = Math.min(minColInRow[row], col);
            maxColInRow[row] = Math.max(maxColInRow[row], col);
        }

        int result = 0;
        for (int i = 0; i < buildings.length; i++) {
            int row = buildings[i][0];
            int col = buildings[i][1];

            if (minRowInCol[col] < row && row < maxRowInCol[col] && 
                minColInRow[row] < col && col < maxColInRow[row]) {
                result++;
            }
        }
        return result;
    }
}