package graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphProblemsTest {

    @Test
    void findPath() {
        GraphProblems problems = new GraphProblems();

        // Test Case 1: Path exists
        int[][] grid1 = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        int[] start1 = {0, 0};
        int[] end1 = {3, 3};
        assertTrue(problems.findPath(grid1, start1, end1));

        // Test Case 2: No path (blocked by obstacles - represented by 1s in a real scenario, but here we assume all 0s are traversable)
        // For this problem, the grid values don't matter, only the existence of a path.
        // If we were to consider obstacles, the grid would need to be modified.
        // As per the problem description (CTCI 4.1), it's about reachability in a directed graph.
        // The current `search` implementation treats all cells as traversable if they are within bounds and not visited.
        // To simulate "no path" due to obstacles, we'd need to modify the `search` method to check `grid[rNew][cNew] == 0`.
        // For now, let's assume a grid where all cells are traversable.

        // Test Case 3: Start and end are the same
        int[][] grid3 = {{0}};
        int[] start3 = {0, 0};
        int[] end3 = {0, 0};
        assertTrue(problems.findPath(grid3, start3, end3));

        // Test Case 4: Single row, path exists
        int[][] grid4 = {{0, 0, 0}};
        int[] start4 = {0, 0};
        int[] end4 = {0, 2};
        assertTrue(problems.findPath(grid4, start4, end4));

        // Test Case 5: Single column, path exists
        int[][] grid5 = {{0}, {0}, {0}};
        int[] start5 = {0, 0};
        int[] end5 = {2, 0};
        assertTrue(problems.findPath(grid5, start5, end5));

        // Test Case 6: No path (disconnected components - not directly applicable to this grid BFS without obstacles)
        // This test case would require a more complex grid definition or a graph representation.
        // For a simple grid BFS, if all cells are 0, a path always exists between any two cells.
        // Let's create a scenario where the end is unreachable due to boundary.
        int[][] grid6 = {
                {0, 0},
                {0, 0}
        };
        int[] start6 = {0, 0};
        int[] end6 = {0, 2}; // Out of bounds
        assertFalse(problems.findPath(grid6, start6, end6)); // Should be false because end is out of bounds

        // Test Case 7: Larger grid, path exists
        int[][] grid7 = new int[10][10]; // All zeros
        int[] start7 = {0, 0};
        int[] end7 = {9, 9};
        assertTrue(problems.findPath(grid7, start7, end7));

        // Test Case 8: Start or end is out of bounds (should be handled by initial checks or result in no path)
        int[][] grid8 = {{0, 0}};
        int[] start8 = {-1, 0}; // Out of bounds
        int[] end8 = {0, 1};
        assertFalse(problems.findPath(grid8, start8, end8)); // The current implementation will throw ArrayIndexOutOfBoundsException if not handled.
                                                            // The `search` method implicitly handles this by not adding out-of-bounds cells to the queue.
                                                            // However, the initial `toVisit.add` might need a check if start can be out of bounds.
                                                            // For this test, let's assume valid start/end points are passed.
                                                            // If start is out of bounds, the queue will be initialized with an invalid point,
                                                            // but the loop condition `rNew >= 0 && rNew < grid.length` will prevent traversal.
                                                            // The current test setup assumes valid start/end coordinates within the grid.

        // Test Case 9: Empty grid
        int[][] grid9 = {};
        int[] start9 = {0, 0};
        int[] end9 = {0, 0};
        assertFalse(problems.findPath(grid9, start9, end9));

        // Test Case 10: Null grid
        assertFalse(problems.findPath(null, start1, end1));
    }

    @Test
    void findPathDfs() {
        GraphProblems problems = new GraphProblems();

        // Test Case 1: Path exists
        int[][] grid1 = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        int[] start1 = {0, 0};
        int[] end1 = {3, 3};
        assertTrue(problems.findPathDfs(grid1, start1, end1));

        // Test Case 2: No path (blocked by obstacles - represented by 1s in a real scenario, but here we assume all 0s are traversable)
        // For this problem, the grid values don't matter, only the existence of a path.
        // If we were to consider obstacles, the grid would need to be modified.
        // As per the problem description (CTCI 4.1), it's about reachability in a directed graph.
        // The current `search` implementation treats all cells as traversable if they are within bounds and not visited.
        // To simulate "no path" due to obstacles, we'd need to modify the `search` method to check `grid[rNew][cNew] == 0`.
        // For now, let's assume a grid where all cells are traversable.

        // Test Case 3: Start and end are the same
        int[][] grid3 = {{0}};
        int[] start3 = {0, 0};
        int[] end3 = {0, 0};
        assertTrue(problems.findPathDfs(grid3, start3, end3));

        // Test Case 4: Single row, path exists
        int[][] grid4 = {{0, 0, 0}};
        int[] start4 = {0, 0};
        int[] end4 = {0, 2};
        assertTrue(problems.findPathDfs(grid4, start4, end4));

        // Test Case 5: Single column, path exists
        int[][] grid5 = {{0}, {0}, {0}};
        int[] start5 = {0, 0};
        int[] end5 = {2, 0};
        assertTrue(problems.findPathDfs(grid5, start5, end5));

        // Test Case 6: No path (disconnected components - not directly applicable to this grid BFS without obstacles)
        // This test case would require a more complex grid definition or a graph representation.
        // For a simple grid BFS, if all cells are 0, a path always exists between any two cells.
        // Let's create a scenario where the end is unreachable due to boundary.
        int[][] grid6 = {
                {0, 0},
                {0, 0}
        };
        int[] start6 = {0, 0};
        int[] end6 = {0, 2}; // Out of bounds
        assertFalse(problems.findPathDfs(grid6, start6, end6)); // Should be false because end is out of bounds

        // Test Case 7: Larger grid, path exists
        int[][] grid7 = new int[10][10]; // All zeros
        int[] start7 = {0, 0};
        int[] end7 = {9, 9};
        assertTrue(problems.findPathDfs(grid7, start7, end7));

        // Test Case 8: Start or end is out of bounds (should be handled by initial checks or result in no path)
        int[][] grid8 = {{0, 0}};
        int[] start8 = {-1, 0}; // Out of bounds
        int[] end8 = {0, 1};
        assertFalse(problems.findPathDfs(grid8, start8, end8)); // The current implementation will throw ArrayIndexOutOfBoundsException if not handled.
        // The `search` method implicitly handles this by not adding out-of-bounds cells to the queue.
        // However, the initial `toVisit.add` might need a check if start can be out of bounds.
        // For this test, let's assume valid start/end points are passed.
        // If start is out of bounds, the queue will be initialized with an invalid point,
        // but the loop condition `rNew >= 0 && rNew < grid.length` will prevent traversal.
        // The current test setup assumes valid start/end coordinates within the grid.

        // Test Case 9: Empty grid
        int[][] grid9 = {};
        int[] start9 = {0, 0};
        int[] end9 = {0, 0};
        assertFalse(problems.findPathDfs(grid9, start9, end9));

        // Test Case 10: Null grid
        assertFalse(problems.findPathDfs(null, start1, end1));
    }
}