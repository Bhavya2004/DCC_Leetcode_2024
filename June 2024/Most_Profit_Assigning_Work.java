class Solution {
    class Job implements Comparable<Job> {
        int difficulty;
        int profit;

        public Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }

        @Override
        public int compareTo(Job other) {
            return this.difficulty - other.difficulty;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        // Sort jobs by difficulty in ascending order
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs);

        // Sort workers by ability in ascending order
        Arrays.sort(worker);

        int maxProfit = 0;
        int i = 0;
        int bestProfit = 0;

        for (int ability : worker) {
            while (i < n && ability >= jobs[i].difficulty) {
                bestProfit = Math.max(bestProfit, jobs[i].profit);
                i++;
            }
            maxProfit += bestProfit;
        }

        return maxProfit;
    }
}