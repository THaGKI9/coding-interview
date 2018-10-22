package P029;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> rv = new ArrayList<>();

        if (k > input.length) return rv;

        Arrays.sort(input);
        for (int i = 0; i < k && i < input.length; i++) {
            rv.add(input[i]);
        }

        return rv;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.GetLeastNumbers_Solution(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 4));
    }
}
