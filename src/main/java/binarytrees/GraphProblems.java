package binarytrees;

import java.util.HashSet;
import java.util.Set;

public class GraphProblems {

    /**
     * CTCI 4.1: Route Between Nodes: Given a directed graph, design an algorithm to find out whether
     * there is a route between two nodes.
     */
    public <T> boolean routeBetweenNodes(Vertex<T> start, Vertex<T> end) {
        return dfs(start, end, new HashSet<>());
    }

    public <T> boolean dfs(Vertex<T> start, Vertex<T> end, Set<Vertex<T>> visited) {
        if (start == end) return true;
        visited.add(start);
        for (Vertex<T> vertex : start.adjacencyList) {
            if (!visited.contains(vertex)) {
                if (dfs(vertex, end, visited)) return true;
            }
        }
        return false;
    }



}
