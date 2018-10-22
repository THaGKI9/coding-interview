package P007;

public class Solution {
    public int Fibonacci(int n) {
        int lastSecond = 0;
        int last = 1;

        if (n == 0) return 0;


        for (; n > 1; n--) {
            int newNum = lastSecond + last;
            lastSecond = last;
            last = newNum;
        }

        return last;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        System.out.println(solver.Fibonacci(0));
        System.out.println(solver.Fibonacci(1));
        System.out.println(solver.Fibonacci(3));
        System.out.println(solver.Fibonacci(4));
        System.out.println(solver.Fibonacci(5));
        System.out.println(solver.Fibonacci(6));
        System.out.println(solver.Fibonacci(7));
    }
}
