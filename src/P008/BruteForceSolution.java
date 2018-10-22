package P008;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tonyke on 9/10/2018
 */
public class BruteForceSolution {
    public Map<Integer, Integer> walks = new HashMap<>();

    public int JumpFloor(int target, int step1, int step2) {
        if (target == 0) {
            int times = walks.getOrDefault(step1 * 100 + step2, 0);
            walks.put(step1 * 100 + step2, times + 1);
            return 1;
        }

        if (target < 0) return 0;
        return JumpFloor(target - 2, step1, step2 + 1)
                + JumpFloor(target - 1, step1 + 1, step2);
    }

    public static void main(String[] main) {
        BruteForceSolution solver = new BruteForceSolution();
        solver.JumpFloor(29, 0, 0);
        System.out.println(solver.walks);
    }
}
