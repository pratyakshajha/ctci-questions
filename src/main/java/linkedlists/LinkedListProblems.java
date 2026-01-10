package linkedlists;

import java.util.HashSet;
import java.util.Set;

public class LinkedListProblems {

    /**
     * CTCI 2.1: Remove Dups: Write code to remove duplicates from an unsorted linked list
     */
    public Node removeDuplicates(Node head) {
        if (head == null) return null;

        Set<Integer> set = new HashSet<>();
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (set.contains(current.data)) {
                previous.next = current.next;
            } else {
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }
        return head;
    }

    public Node removeDuplicatesNoBuffer(Node head) {
        if (head == null) return null;
        Node current = head;
        while (current != null) {
            int data = current.data;
            Node runner = current;
            while (runner != null) {
                if (runner.next != null && runner.next.data == data)
                    runner.next = runner.next.next;
                else
                    runner = runner.next;
            }
            current = current.next;
        }
        return head;
    }
}
