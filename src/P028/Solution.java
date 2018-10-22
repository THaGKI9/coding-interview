package P028;

import java.util.HashMap;

/**
 * Created by tonyke on 11/10/2018
 * <p>
 * 数组中出现次数超过一半的数字
 * 思路：
 * 1. 用 Map 存每个数字出现过的次数（怕超时）
 * 2. 排序，然后遍历数组的前半部分，如果 array[i] = array[i + n/2] 则 array[i] 为那个数
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> valToTimesMap = new HashMap<>();
        int halfLength = array.length >> 1;
        for (int i : array) {
            int times = valToTimesMap.getOrDefault(i, 0) + 1;
            if (times > halfLength) return i;
            valToTimesMap.put(i, times);
        }
        return 0;
    }
}
