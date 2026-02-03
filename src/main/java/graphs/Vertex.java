package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Vertex<T> {
    public T data;
    public List<Vertex<T>> adjacencyList = new ArrayList<>();
    public Vertex<T>[] adjacents;
    public boolean isDirected = false;

    public Vertex(T data) {
        this.data = data;
    }

    public void addAdjacents(Vertex<T>[] adjacents) {
        this.adjacents = adjacents;
    }

    public void addEdge(Vertex<T> destination) {
        this.adjacencyList.add(destination);
        if (!isDirected) destination.adjacencyList.add(this);
    }

    public void removeEdge(Vertex<T> destination) {
        this.adjacencyList.remove(destination);
        if (!isDirected) destination.adjacencyList.remove(this);
    }

    // all vertices are unique by data
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vertex<?> vertex)) return false;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        if (data != null) sb.append(data);
        if (!adjacencyList.isEmpty()) sb.append(", adjacencyList=").append(adjacencyList);
        if (adjacents != null) sb.append(", adjacents=").append(Arrays.toString(adjacents));
        if (isDirected) sb.append(", isDirected=").append(true);
        sb.append(" }");
        return sb.toString();
    }
}
