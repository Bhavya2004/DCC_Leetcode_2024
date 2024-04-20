class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> groups = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int r1 = i, c1 = j, r2 = i, c2 = j;
                    while (r2 + 1 < m && land[r2 + 1][j] == 1) {
                        r2++;
                    }
                    while (c2 + 1 < n && land[i][c2 + 1] == 1) {
                        c2++;
                    }
                    groups.add(new int[]{r1, c1, r2, c2});
                    for (int r = r1; r <= r2; r++) {
                        for (int c = c1; c <= c2; c++) {
                            land[r][c] = 0;
                        }
                    }
                }
            }
        }

        int[][] result = new int[groups.size()][4];
        for (int i = 0; i < groups.size(); i++) {
            result[i] = groups.get(i);
        }
        return result;
    }
}