class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0;

        int maxDistance = 0;
        int[] current = new int[]{0, 0};

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        for (int command : commands) {
            if (command == -2) { // Tourner à gauche
                dirIndex = (dirIndex + 3) % 4;
            } else if (command == -1) { // Tourner à droite
                dirIndex = (dirIndex + 1) % 4;
            } else {  // Avancer
                int x = directions[dirIndex][0];
                int y = directions[dirIndex][1];

                for (int i = 0; i < command; i++) {
                    int nextX = current[0] + x;
                    int nextY = current[1] + y;

                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break;
                    }
                    current[0] = nextX;
                    current[1] = nextY;
                    maxDistance = Math.max(maxDistance, current[0] * current[0] + current[1] * current[1]);
                }
            }
        }
        return maxDistance;
    }
}