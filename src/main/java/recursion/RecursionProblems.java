package recursion;

import java.util.Arrays;

public class RecursionProblems {

    /**
     * CTCI 8.1: Triple Step: A child is running up a staircase with n steps and can hop either
     * 1 step, 2 steps, or 3 steps at a time. Implement a method to count how many possible ways
     * the child can run up the stairs.
     */
    public int countWays(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        return countWays(n-1) + countWays(n-2) + countWays(n-3);
    }

    public int countWaysDp(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countWaysDpHelper(n, memo);
    }

    public int countWaysDpHelper(int n, int[] memo) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (memo[n] > -1) return memo[n];
        memo[n] = countWaysDpHelper(n-1, memo) + countWaysDpHelper(n-2, memo) + countWaysDpHelper(n-3, memo);
        return memo[n];
    }


}
