public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int satisfied = 0;
        int maxSatisfied = 0;
        int windowSum = 0;

        // Calculate the initial sum of satisfied customers
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }

        // Calculate the sum of satisfied customers in the sliding window
        for (int i = 0; i < minutes; i++) {
            windowSum += customers[i] * grumpy[i];
        }
        maxSatisfied = Math.max(maxSatisfied, satisfied + windowSum);

        // Slide the window and update the sum of satisfied customers
        for (int i = minutes; i < n; i++) {
            windowSum += customers[i] * grumpy[i] - customers[i - minutes] * grumpy[i - minutes];
            maxSatisfied = Math.max(maxSatisfied, satisfied + windowSum);
        }

        return maxSatisfied;
    }
}