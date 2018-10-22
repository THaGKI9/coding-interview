package P021;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tonyke on 10/10/2018
 * <p>
 * 栈的压入、弹出序列
 */
public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Map<Integer, Integer> valToIndex = new HashMap<>();

        for (int i = 0; i < pushA.length; i++) valToIndex.put(pushA[i], i);

        if (pushA.length < popA.length) return false;
        for (int i : popA) if (!valToIndex.containsKey(i)) return false;

        for (int i = 0; i < popA.length; i++) {
            int indexA = valToIndex.get(popA[i]);
            int lastSmaller = pushA.length + 1;
            for (int j = i + 1; j < popA.length; j++) {
                int indexB = valToIndex.get(popA[j]);
                if (indexB < indexA) {
                    if (indexB < lastSmaller) lastSmaller = indexB;
                    else return false;
                }
            }
        }
        return true;
    }
}
