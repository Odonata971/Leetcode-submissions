class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        //Matrix initialized with distances in it
        int[][] distances = new int[n][n];

        //Fill the distances with infinity for the moment
        for (int i = 0; i < n; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        // changes the distance to itself to 0
        for (int i = 0; i < n; i++) {
            distances[i][i] = 0;
        }

        //put the right distances in the distance matrix
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            distances[u][v] = w;
            distances[v][u] = w;
        }

        // Floyd Warshall algorithm (see more there : https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm)
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][k] != Integer.MAX_VALUE 
                        && distances[k][j] != Integer.MAX_VALUE 
                        && distances[i][j] > distances[i][k] + distances[k][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }

        int minReachableCities = n;
        int city = -1;
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (distances[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            if (reachableCities <= minReachableCities) {
                minReachableCities = reachableCities;
                city = i;
            }
        }
        return city;
    }
}