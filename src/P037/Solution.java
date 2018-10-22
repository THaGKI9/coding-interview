package P037;

/**
 * Created by tonyke on 19/10/2018
 * 数字在排序数组中出现的次数
 * 思路：
 * 大力梭
 */
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i: array) if (i == k) count++;
        return count;
    }
}
