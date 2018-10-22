package P051;

import java.util.Arrays;

/**
 * Created by tonyke on 12/10/2018
 * 构建乘积数组
 * 思路：
 * 可以先算好a0...an的乘积，算 bn 的时候再用乘积 / i
 * 要注意 bi = 0 的情况
 */
public class Solution {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return null;

        long zeros = Arrays.stream(A)
                .filter(i -> i == 0)
                .count();
        long product = Arrays.stream(A)
                .mapToLong(i -> i)
                .reduce(1, (a, b) -> a * (b != 0 || zeros > 1 ? b : 1));
        return Arrays.stream(A)
                .map(i -> {
                    if (i != 0) {
                        if (zeros == 0) return (int) (product / i);
                        else return 0;
                    } else {
                        if (zeros == 1) return (int) product;
                        else return 0;
                    }
                })
                .toArray();
    }
}