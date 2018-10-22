package P034;

import java.util.HashMap;

/**
 * Created by tonyke on 19/10/2018
 * 第一个只出现一次的字符
 * 思路
 * 用 HashMap 来记录每个字母出现的次数，从字符串尾部开始
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> times = new HashMap<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            times.put(c, times.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (times.getOrDefault(str.charAt(i), 2) == 1) {
                return i;
            }
        }

        return -1;
    }
}
