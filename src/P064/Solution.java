package P064;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by tonyke on 15/10/2018
 * 滑动窗口的最大值
 * 思路：
 * 暴力，但是不要重复计算，要有技巧
 */
public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> maxValues = new ArrayList<>();
        PriorityQueue<Integer> window = new PriorityQueue<>((num1, num2) -> num2 - num1);
        if (size > num.length || num.length == 0 || size == 0) return maxValues;

        for (int i = 0; i <= num.length - size; i++) {
            if (i == 0) {
                int tmp = size - 1;
                while (tmp-- > 0)
                    window.offer(num[tmp]);
            }

            if (i != 0) window.remove(num[i - 1]);
            window.add(num[i + size - 1]);

            maxValues.add(window.peek());
        }

        return maxValues;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
    }
}
