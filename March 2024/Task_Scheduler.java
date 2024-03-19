class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count the frequency of each task
        int[] taskCount = new int[26];
        for (char task : tasks) {
            taskCount[task - 'A']++;
        }
        
        Arrays.sort(taskCount);
        
        int maxFreq = taskCount[25];
        
        // Calculate the number of idle intervals required
        int idleIntervals = (maxFreq - 1) * n;
        
        // Iterate over the remaining tasks and subtract their frequencies from the idle intervals
        for (int i = 24; i >= 0 && taskCount[i] > 0; i--) {
            idleIntervals -= Math.min(maxFreq - 1, taskCount[i]);
        }
        
        // Calculate the minimum number of intervals required
        return tasks.length + Math.max(0, idleIntervals);
    }
}
