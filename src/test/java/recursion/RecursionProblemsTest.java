package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursionProblemsTest {

    @Test
    void countWays() {
        RecursionProblems problems = new RecursionProblems();

        // Test Case 1: 0 steps (1 way: stay put)
        assertEquals(1, problems.countWays(0));

        // Test Case 2: 1 step (1 way: [1])
        assertEquals(1, problems.countWays(1));

        // Test Case 3: 2 steps (2 ways: [1,1], [2])
        assertEquals(2, problems.countWays(2));

        // Test Case 4: 3 steps (4 ways: [1,1,1], [1,2], [2,1], [3])
        assertEquals(4, problems.countWays(3));

        // Test Case 5: 4 steps (7 ways)
        assertEquals(7, problems.countWays(4));

        // Test Case 6: Negative steps
        assertEquals(0, problems.countWays(-1));
    }

    @Test
    void countWaysDp() {
        RecursionProblems problems = new RecursionProblems();

        // Test Case 1: 0 steps (1 way: stay put)
        assertEquals(1, problems.countWaysDp(0));

        // Test Case 2: 1 step (1 way: [1])
        assertEquals(1, problems.countWaysDp(1));

        // Test Case 3: 2 steps (2 ways: [1,1], [2])
        assertEquals(2, problems.countWaysDp(2));

        // Test Case 4: 3 steps (4 ways: [1,1,1], [1,2], [2,1], [3])
        assertEquals(4, problems.countWaysDp(3));

        // Test Case 5: 4 steps (7 ways)
        assertEquals(7, problems.countWaysDp(4));

        // Test Case 6: Negative steps
        assertEquals(0, problems.countWaysDp(-1));
    }
}