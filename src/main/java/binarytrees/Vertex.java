package binarytrees;

import java.util.ArrayList;
import java.util.List;

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

}
