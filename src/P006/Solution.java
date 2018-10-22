package P006;

/**
 * Created by tonyke on 9/10/2018
 *
 * 旋转数组的最小数字
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) return -1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) return array[i];
        }

        return array[0];
    }

    public static void main(String[] main) {
        Solution solver = new Solution();
        System.out.println(solver.minNumberInRotateArray(new int[] {3,4,5,1,2}));
        System.out.println(solver.minNumberInRotateArray(new int[] {3,2}));
        System.out.println(solver.minNumberInRotateArray(new int[] {2,3}));
    }
}
