package binarytrees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphProblemsTest {

    @Test
    void routeBetweenNodes() {
        GraphProblems problems = new GraphProblems();

        // Test Case 1: Direct route
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        v1.addEdge(v2);
        assertTrue(problems.routeBetweenNodes(v1, v2));

        // Test Case 2: Indirect route
        Vertex<Integer> v3 = new Vertex<>(3);
        v2.addEdge(v3);
        assertTrue(problems.routeBetweenNodes(v1, v3));

        // Test Case 3: No route
        Vertex<Integer> v4 = new Vertex<>(4);
        assertFalse(problems.routeBetweenNodes(v1, v4));

        // Test Case 4: Cycle in graph
        Vertex<Integer> v5 = new Vertex<>(5);
        v3.addEdge(v5);
        v5.addEdge(v1);
        assertTrue(problems.routeBetweenNodes(v1, v5));

        // Test Case 5: Self loop
        Vertex<Integer> v6 = new Vertex<>(6);
        v6.addEdge(v6);
        assertTrue(problems.routeBetweenNodes(v6, v6));

        // Test Case 6: Disconnected components
        Vertex<Integer> v7 = new Vertex<>(7);
        Vertex<Integer> v8 = new Vertex<>(8);
        v7.addEdge(v8);
        assertFalse(problems.routeBetweenNodes(v1, v7));

        // Test Case 7: Start and end are same node
        assertTrue(problems.routeBetweenNodes(v1, v1));

        // Test Case 8: String data type
        Vertex<String> s1 = new Vertex<>("A");
        Vertex<String> s2 = new Vertex<>("B");
        s1.addEdge(s2);
        assertTrue(problems.routeBetweenNodes(s1, s2));
    }
}