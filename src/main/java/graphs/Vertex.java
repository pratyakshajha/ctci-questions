package binarytrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Vertex<T> {
    public T data;
    public List<Vertex<T>> adjacencyList = new ArrayList<>();
    public Vertex<T>[] adjacents;

    public Vertex(T data) {
        this.data = data;
    }

    public void addAdjacents(Vertex<T>[] adjacents) {
        this.adjacents = adjacents;
    }

    public void addEdge(Vertex<T> destination) {
        this.adjacencyList.add(destination);
        destination.adjacencyList.add(this);
    }

    public void removeEdge(Vertex<T> destination) {
        this.adjacencyList.remove(destination);
        destination.adjacencyList.remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vertex<?> vertex)) return false;
        return Objects.equals(data, vertex.data) && Objects.equals(adjacencyList, vertex.adjacencyList) && Objects.deepEquals(adjacents, vertex.adjacents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, adjacencyList, Arrays.hashCode(adjacents));
    }
}
