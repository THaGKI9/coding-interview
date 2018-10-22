package P045;

import java.util.Arrays;

/**
 * Created by tonyke on 12/10/2018
 * <p>
 * 扑克牌顺子
 * 思路：
 * 先排序
 * 1. 没有王，最大牌和最小牌的差 = 4
 */
public class Solution {
    public boolean isContinuous(int[] numbers) {
        int[] cards = numbers.clone();
        Arrays.sort(cards);

        long jokerCount = Arrays.stream(cards)
                .filter((i) -> i == 0)
                .count();

        return numbers.length == 5
                && jokerCount <= 4
                && ((jokerCount == 4)
                || (jokerCount == 3 && cards[4] - cards[3] <= 4 && cards[4] != cards[3])
                || (jokerCount == 2 && cards[4] - cards[2] <= 4 && cards[4] != cards[3] && cards[3] != cards[2])
                || (jokerCount == 1 && cards[4] - cards[1] <= 4 && cards[4] != cards[3] && cards[3] != cards[2] && cards[2] != cards[1])
                || (jokerCount == 0 && cards[4] - cards[0] <= 4 && cards[4] != cards[3] && cards[3] != cards[2] && cards[2] != cards[1] && cards[1] != cards[0]));
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.print(solver.isContinuous(new int[]{1, 0, 0, 5, 0}));
    }
}
