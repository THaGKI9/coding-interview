package P044;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by tonyke on 12/10/2018
 *
 * 翻转单词顺序列
 * 思路：
 * 分割 -> 翻转
 *
 */
public class Solution {
    public String ReverseSentence(String str) {
        if (str.strip().length() == 0) return str;

        List<String> words = Arrays.asList(str.split(" "));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.print(solver.ReverseSentence("I am a student."));
    }
}
