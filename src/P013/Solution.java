package P013;

import java.util.ArrayList;

/**
 * Created by tonyke on 9/10/2018
 */
public class Solution {
    public void reOrderArray(int[] array) {
        /* in-place reordering */
        if (array.length < 2) return;

        ArrayList<Integer> odds = new ArrayList<>();
        ArrayList<Integer> evens = new ArrayList<>();

        for (int i : array) {
            if (i % 2 == 0) evens.add(i);
            else odds.add(i);
        }

        for (int i = 0; i < odds.size(); i++) array[i] = odds.get(i);
        for (int i = 0; i < evens.size(); i++) array[odds.size() + i] = evens.get(i);
    }

    public static void main(String[] args) {
        /**
         * {3, 2, 4, 1, 5, 6} => {3, 1, 5, 2, 4, 6}
         */
        Solution solver = new Solution();
        int arr[] = new int[]{2, 4, 6, 1, 3, 5};

        solver.reOrderArray(arr);
        System.out.println(arr.toString());
    }
}
