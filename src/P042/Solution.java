package P042;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tonyke on 12/10/2018
 * <p>
 * 和为S的两个数字
 * 思路：
 * 建立起 val -> index 的映射
 * 扫一遍数组，寻找另一半
 * O(n) + O(n)
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < array.length; i++) valToIndex.put(array[i], i);

        ArrayList<Integer> rv = new ArrayList<>(2);
        int minProduct = Integer.MAX_VALUE;

        for (int i : array) {
            int j = sum - i;
            if (!valToIndex.containsKey(j)) continue;

            if (i * j < minProduct) {
                rv.clear();
                rv.add(Math.min(i, j));
                rv.add(Math.max(i, j));
            }
        }

        return rv;
    }
}
