import java.util.ArrayList;
import java.util.List;

public class Lucky_Numbers_in_a_Matrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int[] rowMin = new int[m];
        int[] colMax = new int[n];

        // Find the minimum element in each row
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            rowMin[i] = min;
        }

        // Find the maximum element in each column
        for (int j = 0; j < n; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            colMax[j] = max;
        }

        // Check if the element is both the minimum in its row and maximum in its column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    luckyNumbers.add(matrix[i][j]);
                }
            }
        }

        return luckyNumbers;
    }
}