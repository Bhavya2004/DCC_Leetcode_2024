class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        int currTime = 0;
        double totalWaitingTime = 0;

        for (int i = 0; i < n; i++) {
            int arrivalTime = customers[i][0];
            int preparationTime = customers[i][1];

            if (currTime < arrivalTime) {
                currTime = arrivalTime;
            }

            currTime += preparationTime;
            totalWaitingTime += currTime - arrivalTime;
        }

        return totalWaitingTime / n;
    }
}