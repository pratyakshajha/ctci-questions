package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class GraphProblems {

    /**
     * CTCI 4.1: Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
     */
    public boolean findPath(int[][] grid, int[] start, int[] end) {
        if (grid == null || grid.length == 0) return false;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

        Queue<int[]> toVisit = new LinkedList<>();
        toVisit.add(new int[]{start[0],start[1]});
        while (!toVisit.isEmpty()) {
            int[] current = toVisit.poll();
            int r = current[0], c = current[1];
            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
                visited[r][c] = true;

                if (r == end[0] && c == end[1]) return true;
                for (int[] dir : dirs) {
                    int rNew = dir[0] + r;
                    int cNew = dir[1] + c;
                    if (rNew >= 0 && rNew < grid.length && cNew >= 0 && cNew < grid[0].length && !visited[rNew][cNew]) {
                        toVisit.add(new int[]{rNew, cNew});
                    }
                }
            }
        }
        return false;
    }

    public boolean findPathDfs(int[][] grid, int[] start, int[] end) {
        if (grid == null || grid.length == 0) return false;
        return findPathDfsUtil(grid, start, end, new boolean[grid.length][grid[0].length]);
    }

    public boolean findPathDfsUtil(int[][] grid, int[] start, int[] end, boolean[][] visited) {
        if (!(start[0] >= 0 && start[0] < grid.length && start[1] >= 0 && start[1] < grid[0].length)) return false;
        if (start[0] == end[0] && start[1] == end[1]) return true;
        visited[start[0]][start[1]] = true;

        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] dir : dirs) {
            int rNew = dir[0] + start[0];
            int cNew = dir[1] + start[1];
            if ((rNew >= 0 && rNew < grid.length && cNew >= 0 && cNew < grid[0].length) &&
                    !visited[rNew][cNew] &&
                    findPathDfsUtil(grid, new int[]{rNew, cNew}, end, visited)) return true;
        }
        return false;
    }
}
