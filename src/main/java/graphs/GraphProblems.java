package graphs;

import java.util.*;

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

    /**
     * CTCI 4.7: Build Order: You are given a list of projects and a list of dependencies
     * (which is a list of pairs of projects, where the second project is dependent on the
     * first project). All of a project's dependencies must be built before the project is.
     * Find a build order that will allow the projects to be built. If there is no valid build
     * order, return an error.
     */
    public List<String> findBuildOrder(String[] projects, String[][] dependencies) {
        List<Vertex<String>> graph = buildGraph(projects, dependencies);
        Stack<String> intermediate = new Stack<>();
        Set<Vertex<String>> visited = new HashSet<>();
        Set<Vertex<String>> visiting = new HashSet<>(); // use this to avoid cycles
        for (Vertex<String> vertex : graph) {
            if (!visited.contains(vertex)) findBuildOrderHelper(vertex, intermediate, visited, visiting);
        }
        List<String> result = new ArrayList<>();
        while (!intermediate.isEmpty()) result.add(intermediate.pop());
        System.out.println(result);
        return result;
    }

    public List<Vertex<String>> buildGraph(String[] projects, String[][] dependencies) {
        Map<String, Vertex<String>> vertices = new HashMap<>();
        for (String project : projects) {
            Vertex<String> v = new Vertex<>(project);
            v.isDirected = true;
            vertices.put(project, v);
        }
        for (String[] dependency : dependencies) {
            Vertex<String> from = vertices.get(dependency[0]);
            Vertex<String> to = vertices.get(dependency[1]);
            from.addEdge(to);
        }
        return new ArrayList<>(vertices.values());
    }

    public void findBuildOrderHelper(Vertex<String> vertex, Stack<String> intermediate, Set<Vertex<String>> visited, Set<Vertex<String>> visiting) {
        if (visited.contains(vertex)) return;
        if (visiting.contains(vertex)) throw new RuntimeException("Cycle detected");

        visiting.add(vertex);
        for (Vertex<String> adj : vertex.adjacencyList) {
            findBuildOrderHelper(adj, intermediate, visited, visiting);
        }
        visiting.remove(vertex);
        visited.add(vertex);
        intermediate.add(vertex.data);
    }
}
