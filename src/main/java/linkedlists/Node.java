package linkedlists;

public class Node<T> {
    public T value;
    public Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public static <T> String printAsList(Node<T> head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append("-> ");
            current = current.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
