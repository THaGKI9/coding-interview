package P032;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by tonyke on 19/10/2018
 * 把数组排成最小的数
 */
public class Solution {
    public int getDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public String PrintMinNumber(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(numbers).forEach(list::add);

        list.sort((i, j) -> {
            String number1 = String.format("%d%d", i, j);
            String number2 = String.format("%d%d", j, i);
            return number1.compareTo(number2);
        });
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }
}
