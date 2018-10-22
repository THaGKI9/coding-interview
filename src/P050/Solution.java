package P050;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tonyke on 12/10/2018
 * <p>
 * 数组中重复的数字
 * 思路：
 * 遍历，标记，查重
 */
public class Solution {
    /**
     * @param numbers     an array of integers
     * @param length      the length of array numbers
     * @param duplication the duplicated number in the array number, length of duplication array is 1, so using duplication[0] = ? in implementation;
     * @return true if the input is valid, and there are some duplications in the array number
     * otherwise false
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers != null && length > 0) {
            Set<Integer> exist = new HashSet<>();
            for (int i : numbers) {
                if (exist.contains(i)) {
                    duplication[0] = i;
                    return true;
                }

                exist.add(i);
            }
        }

        duplication[0] = -1;
        return false;
    }
}
