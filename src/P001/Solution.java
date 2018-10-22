package P001;

/**
 * Created by tonyke on 14/10/2018
 * 二维数组中的查找
 * 思路：
 * 1. 有序数组 -> 二分查找
 * 2. 换行查找的时候可以做一些优化，不从头开始
 *      1. 比如说比较 array[i][i] 与 target
 */
public class Solution {
    public boolean binarySearch(int[] row, int left, int right, int target) {
        int low = left;
        int high = right;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < row[mid])
                high = mid - 1;
            else if (target > row[mid])
                low = mid + 1;
            else
                return true;
        }

        return false;
    }

    public boolean Find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) return false;

        int maxY = array.length - 1;
        int maxX = array[0].length - 1;
        if (target < array[0][0] || target > array[maxY][maxX]) return false;

        for (int i = 0; i < array.length; i++) {
            int[] row = array[i];
            int pivot = array[i][i];
            boolean found;

            if (target == pivot) return true;
            else if (target < pivot) found = binarySearch(row, 0, i, target);
            else found = binarySearch(row, i, array[i].length - 1, target);

            if (found) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        int[][] array = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15},
        };

        System.out.println(solver.Find(7, array));
    }
}