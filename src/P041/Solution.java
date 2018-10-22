package P041;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tonyke on 12/10/2018
 * <p>
 * 和为S的连续正数序列
 * 思路：
 * 利用等差数列通项公式，分析边界条件，进行枚举
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        // for 1-st item: i, 0 < i < (sum / 2) + 2
        // find n that (2i + n - 1)i = 2sum

        ArrayList<ArrayList<Integer>> rv = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();

        for (int first = 1; first + first + 1 <= target; first++) {
            int delta = (2 * first - 1) * (2 * first - 1) + 8 * sum;
            double length = (-(2 * first - 1) + Math.sqrt(delta)) / 2;

            if (length % 1 == 0) {
                ArrayList<Integer> sequence = new ArrayList<>();
                int lengthInInt = (int)length;
                for (int i = first; i < first + lengthInInt; i++) sequence.add(i);
                rv.add(sequence);
            }
        }

        return rv;
    }
}
