class Solution {
    public double averageWaitingTime(int[][] customers) {
        double sum = 0.0;
        int n = customers.length;
        int availableAt = customers[0][0];
        for (int i = 0; i < n; i++){
            //System.out.println("Sum: " + sum + "  arrival I: " + customers[i][0] + "  time I: " + customers[i][1] + "  availableAt:  "+availableAt);
            sum += (availableAt - customers[i][0]) > 0
            ?(availableAt - customers[i][0]) + customers[i][1]
            : customers[i][1];
            availableAt += (customers[i][0] - availableAt) > 0
            ? (customers[i][0] - availableAt) + customers[i][1] : customers[i][1];
        }
        //System.out.println("Sum: " + sum + "  arrival I: " + customers[n-1][0] + "  time I: " + customers[n-1][1] + "  availableAt:  "+availableAt);
        return sum / n;
    }
}