public class Solution {

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] safeness = calculateSafenessFactors(grid);
        int maxSafeness = findMaxSafeness(safeness);
        return findMaxSafenessFactor(grid, safeness, maxSafeness);
    }

    // Method to calculate the safeness factor for each cell using multi-source BFS
    private int[][] calculateSafenessFactors(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] safeness = new int[n][n];
        for (int[] row : safeness) Arrays.fill(row, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.add(new int[]{i, j});
                    safeness[i][j] = 0;
                }
            }
        }

        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dirX[i];
                int newY = y + dirY[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && safeness[newX][newY] > safeness[x][y] + 1) {
                    safeness[newX][newY] = safeness[x][y] + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        return safeness;
    }

    // Method to find the maximum safeness value from the safeness matrix
    private int findMaxSafeness(int[][] safeness) {
        int maxSafeness = 0;
        for (int[] row : safeness) {
            for (int val : row) {
                maxSafeness = Math.max(maxSafeness, val);
            }
        }
        return maxSafeness;
    }

    // Method to perform binary search to find the maximum safeness factor
    private int findMaxSafenessFactor(List<List<Integer>> grid, int[][] safeness, int maxSafeness) {
        int left = 0;
        int right = maxSafeness;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canAchieveSafeness(grid, safeness, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Method to check if a path with the given safeness factor exists using BFS
    private boolean canAchieveSafeness(List<List<Integer>> grid, int[][] safeness, int threshold) {
        int n = grid.size();
        if (safeness[0][0] < threshold) return false;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            if (x == n - 1 && y == n - 1) return true;

            for (int i = 0; i < 4; i++) {
                int newX = x + dirX[i];
                int newY = y + dirY[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY] && safeness[newX][newY] >= threshold) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        return false;
    }
}