package P019;

/**
 * Created by tonyke on 10/10/2018
 * <p>
 * 顺时针打印矩阵
 */

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        ArrayList<Integer> rv = new ArrayList<>();
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                visit[i][j] = false;
            }
        }

        // 0-right, 1->down, 2->left, 3->up
        int direction = 0;
        int i = 0;
        int j = 0;
        int maxI = matrix.length - 1;
        int maxJ = matrix[0].length - 1;

        while (0 <= i && i <= maxI
                && 0 <= j && j <= maxJ
                && !visit[i][j]) {
            rv.add(matrix[i][j]);
            visit[i][j] = true;

            int newI = i + directions[direction][0];
            int newJ = j + directions[direction][1];

            if (0 > newI || newI > maxI
                    || 0 > newJ || newJ > maxJ
                    || visit[newI][newJ]) {
                direction = (direction + 1) % 4;
                newI = i + directions[direction][0];
                newJ = j + directions[direction][1];
            }

            i = newI;
            j = newJ;
        }

        return rv;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1}
        };

        Solution solution = new Solution();
        solution.printMatrix(matrix).forEach(
                System.out::println
        );
    }
}