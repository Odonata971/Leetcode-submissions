class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int n = rows * cols - 1;
        int spiralWidth = 1;

        int[][] coordinates = new int[n + 1][2];

        int coordinatesCount = 0;
        coordinates[coordinatesCount++] = new int[]{rStart, cStart};

        while (n > 0) {
            //north
            int x = 1, y = 0;
            for (int i = 0; i < spiralWidth; i++) {
                cStart += x;
                if (cStart >= 0 && cStart < cols && rStart >= 0 && rStart < rows) {
                    coordinates[coordinatesCount++] = new int[]{rStart, cStart};
                    n--;
                }
            }

            //east
            x = 0;
            y = 1;
            for (int i = 0; i < spiralWidth; i++) {
                rStart += y;
                if (cStart >= 0 && cStart < cols && rStart >= 0 && rStart < rows) {
                    coordinates[coordinatesCount++] = new int[]{rStart, cStart};
                    n--;
                }
            }
            spiralWidth++;
            //south
            x = -1;
            y = 0;
            for (int i = 0; i < spiralWidth; i++) {
                cStart += x;
                if (cStart >= 0 && cStart < cols && rStart >= 0 && rStart < rows) {
                    coordinates[coordinatesCount++] = new int[]{rStart, cStart};
                    n--;
                }
            }

            x = 0;
            y = -1;
            for (int i = 0; i < spiralWidth; i++) {
                rStart += y;
                if (cStart >= 0 && cStart < cols && rStart >= 0 && rStart < rows) {
                    coordinates[coordinatesCount++] = new int[]{rStart, cStart};
                    n--;
                }
            }
            spiralWidth++;
        }
        return coordinates;

    }
}