package P030;


/**
 * Created by tonyke on 19/10/2018
 * 连续子数组的最大和
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int currentSum = 0;
        int greatestSum = Integer.MIN_VALUE;

        for (int number : array) {
            if (currentSum <= 0) currentSum = number;
            else currentSum += number;
            greatestSum = Math.max(greatestSum, currentSum);
        }

        return greatestSum;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] numbers = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(solver.FindGreatestSumOfSubArray(numbers));
    }
}
