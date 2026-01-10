package linkedlists;

public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public void append(Node head, int data) {
        Node last = new Node(data);

        if (head == null) {
            head = last;
            return;
        }

        Node current = head;
        while (current.next != null) current = current.next;
        current.next = last;
    }

    public static String printAsList(Node head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append("-> ");
            current = current.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
