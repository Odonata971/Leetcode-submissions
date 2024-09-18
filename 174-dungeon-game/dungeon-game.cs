public class Solution {
    public int CalculateMinimumHP(int[][] dungeon) {
        int n = dungeon.Length;
        int m = dungeon[0].Length;
        int[,] healthRequired = new int[n,m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                healthRequired[i,j] = healthCalc(dungeon, healthRequired, i, j, n, m);
            }
        }

        return healthRequired[0,0];
    }

    private int healthCalc(int[][] dungeon, int[,] healthRequired, int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return Math.Max(1, 1 - dungeon[i][j]);
        } else if (i == n - 1) { // bottom row
            return Math.Max(1, healthRequired[i,j + 1] - dungeon[i][j]);
        } else if (j == m - 1) { // right column
            return Math.Max(1, healthRequired[i + 1,j] - dungeon[i][j]);
        } else {
            int right = Math.Max(1, healthRequired[i,j + 1] - dungeon[i][j]);
            int bottom = Math.Max(1, healthRequired[i + 1,j] - dungeon[i][j]);
            return Math.Min(right, bottom);
        }
    }
}