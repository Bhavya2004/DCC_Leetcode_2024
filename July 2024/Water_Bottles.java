class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalBottles = numBottles;
        int emptyBottles = numBottles;

        while (emptyBottles >= numExchange) {
            int exchangedBottles = emptyBottles / numExchange;
            totalBottles += exchangedBottles;
            emptyBottles = exchangedBottles + (emptyBottles % numExchange);
        }

        return totalBottles;
    }
}