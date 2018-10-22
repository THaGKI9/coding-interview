package P027;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by tonyke on 11/10/2018
 * <p>
 * 字符串的排列
 * 思路：
 * dfs
 */
public class Solution {
    public LinkedHashSet<String> Permutation(char[] str, HashSet<Integer> taken, String current, LinkedHashSet<String> result) {
        if (current.length() == str.length) {
            if (!result.contains(current)) result.add(current);
            return result;
        }

        for (int i = 0; i < str.length; i++) {
            if (taken.contains(i)) continue;
            taken.add(i);
            Permutation(str, taken, current + str[i], result);
            taken.remove(i);
        }

        return result;
    }

    public ArrayList<String> Permutation(String str) {
        str = str.trim();
        if (str.equals("")) return new ArrayList<>();
        LinkedHashSet<String> result = Permutation(str.toCharArray(), new HashSet<>(), "", new LinkedHashSet<>());
        return new ArrayList<>(result);
    }

    public static void main(String args[]) {
        Solution solver = new Solution();
        var result = solver.Permutation("a");
        System.out.println(result);
    }
}
