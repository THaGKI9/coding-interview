package P054;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by tonyke on 12/10/2018
 * <p>
 * 字符流中第一个不重复的字符
 * 思路：
 * Insert 的时候记录有没有出现过，保留没有出现过的 index
 */
public class Solution {
    private ArrayList<Character> chars = new ArrayList<>();
    HashSet<Character> insertedOnce = new HashSet<>();
    HashSet<Character> insertedMoreThanOnce = new HashSet<>();
    private int firstAppearingOnceIndex = 0;

    private int FindNextFirstAppearingOnce() {
        for (int i = firstAppearingOnceIndex + 1; i < chars.size(); i++) {
            char ch = chars.get(i);
            if (insertedOnce.contains(ch) && !insertedMoreThanOnce.contains(ch)) return i;
        }

        return -1;
    }

    //Insert one char from stringstream
    public void Insert(char ch) {
        chars.add(ch);

        if (insertedOnce.contains(ch)) {
            insertedMoreThanOnce.add(ch);
            if (firstAppearingOnceIndex != -1 && chars.get(firstAppearingOnceIndex) == ch) {
                firstAppearingOnceIndex = FindNextFirstAppearingOnce();
            }
        } else {
            insertedOnce.add(ch);
            if (firstAppearingOnceIndex == -1) firstAppearingOnceIndex = chars.size() - 1;
        }
    }

    // return the first appearence once char in current string stream
    public char FirstAppearingOnce() {
        if (firstAppearingOnceIndex == -1) return '#';
        else return chars.get(firstAppearingOnceIndex);
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        solver.Insert('g');
        System.out.println(solver.FirstAppearingOnce());
        solver.Insert('o');
        solver.Insert('o');
        solver.Insert('g');
        solver.Insert('l');
        solver.Insert('e');
        System.out.println(solver.FirstAppearingOnce());
    }
}
