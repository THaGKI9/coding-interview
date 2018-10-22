package P065;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tonyke on 14/10/2018
 * 矩阵中的路径
 * 思路：
 * 找起点，走路，标记已走
 */
public class Solution {
    private final int directions[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    public boolean walk(char[] matrix, int rows, int cols, char[] path, int depth, int pos, HashSet<Integer> walked) {
        if (depth == path.length) return true;
        walked.add(pos);

        int row = pos / cols;
        int col = pos % cols;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            int newPos = newRow * cols + newCol;
            boolean walkable = 0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols;

            if (walkable && !walked.contains(newPos) && path[depth] == matrix[newPos]) {
                boolean found = walk(matrix, rows, cols, path, depth + 1, newPos, walked);
                if (found) return true;
            }
        }

        walked.remove(pos);
        return false;
    }


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (str.length == 0 || matrix.length == 0) return false;

        for (int pos = 0; pos < matrix.length; ++pos) {
            if (matrix[pos] != str[0]) continue;

            boolean found = walk(matrix, rows, cols, str, 1, pos, new HashSet<>());
            if (found) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        System.out.println(solver.hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray()));
    }
}
